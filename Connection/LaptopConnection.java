package com.jspider.JDBC_CURD_Test.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class LaptopConnection {

	
	public static Connection getLaptopConnection() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-m11", "root", "Naveen123@");
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}


