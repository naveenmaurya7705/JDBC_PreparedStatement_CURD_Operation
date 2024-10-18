package com.jspider.JDBC_CURD_Test.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jspider.JDBC_CURD_Test.Connection.LaptopConnection;
import com.jspider.JDBC_CURD_Test.DTO.Laptop;

public class LaptopDAO {

	


		Connection connection = LaptopConnection.getLaptopConnection();

		public final String InsertLaptopQuery = "insert into laptop(id,name,color,price,mfd) values(?,?,?,?,?)";

		public final String DeleteLaptopByIdQuery = "DELETE from laptop where id=?";
		
		public final String UpdateNameByID = "Update Laptop set name= ? where id= ?";

		public final String SelectLaptopById = "SELECT * FROM laptop where id=?";
		
		public final String SelectAllLaptops = "SELECT * from laptop";
		
		
		
		public Laptop saveLaptopDao(Laptop laptop) {

			try {
				PreparedStatement ps = connection.prepareStatement(InsertLaptopQuery);
				ps.setInt(1, laptop.getId());
				ps.setString(2, laptop.getName());
				ps.setString(3, laptop.getColor());
				ps.setInt(4, laptop.getPrice());
				ps.setObject(5, laptop.getMfd());

				ps.execute();

				return laptop;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}
		}
		

		public boolean deleteLaptopById(int laptopId) {

			try {
				PreparedStatement ps = connection.prepareStatement(DeleteLaptopByIdQuery);
				ps.setInt(1, laptopId);

				int a = ps.executeUpdate();

				if (a != 0) {
					return true;
				} else {
					return false;
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}

		}
		
		
		public boolean UpdateNameByID( String newName ,int laptopID) {
			try {
				PreparedStatement ps = connection.prepareStatement(UpdateNameByID);
				ps.setString(1, newName);
				ps.setInt(2, laptopID);
				
				int a = ps.executeUpdate();
				if (a != 0) {
					return true;
				} else {
					return false;
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
				return false;
			}
			
		}


		public Laptop getLaptopById(int laptopId) {

			try {
				PreparedStatement ps = connection.prepareStatement(SelectLaptopById);
				ps.setInt(1, laptopId);

				ResultSet set = ps.executeQuery();

				if (set.next()) {

					return new Laptop(set.getInt("id"), set.getString("name"), set.getString("color"), set.getInt("price"), set.getDate("mfd").toLocalDate());
					
				} else {
					return null;
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}

	
		public List<Laptop> getAllLaptops() {

			try {
				PreparedStatement ps = connection.prepareStatement(SelectAllLaptops);
		
				ResultSet set = ps.executeQuery();
				
				List<Laptop> laptops = new ArrayList<Laptop>();

				while(set.next()) {

					Laptop laptop=new Laptop(set.getInt("id"), set.getString("name"), set.getString("color"), set.getInt("price"), set.getDate("mfd").toLocalDate());
					
					laptops.add(laptop);
				}
				return laptops;
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}

		}
}
	
