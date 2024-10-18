package com.jspider.JDBC_CURD_Test.Controller;

import java.sql.Connection;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.jspider.JDBC_CURD_Test.Connection.LaptopConnection;
import com.jspider.JDBC_CURD_Test.Service.LaptopService;
import com.jspider.JDBC_CURD_Test.DAO.LaptopDAO;
import com.jspider.JDBC_CURD_Test.DTO.Laptop;

public class LaptopController {

	public static void main(String[] args) {
		

		Scanner scanner = new Scanner(System.in);
		
				LaptopDAO dao = new LaptopDAO();
				
				LaptopService service = new LaptopService();
				
				Connection connection  = LaptopConnection.getLaptopConnection();
				
				while (true) {
					System.out.println("1.Insert \n2.UpdateName \n3.Delete\n4.DisplayByID\n5.DisplayAllLaptops");
		
					System.out.println("enter your option");
		
					int option = scanner.nextInt();
		
					switch (option) {
				
			case 1:{
					System.out.println("Enter Laptop Id");
					int id = scanner.nextInt();
					scanner.nextLine();
					System.out.println("Enter Laptop Name");
					String name = scanner.nextLine();
					System.out.println("Enter Laptop Color");
					String color = scanner.nextLine();
					System.out.println("Enter Laptop price");
					int price = scanner.nextInt();
	
					System.out.println("Enter manufacturing Date");
					String mfd=scanner.next();
					
					LocalDate mfd1=LocalDate.parse(mfd);
					
					Laptop laptop=new Laptop(id, name, color, price, mfd1);
					
					Laptop saveLaptop=service.saveUserService(laptop);
					
					if(saveLaptop!=null) {
						System.out.println("Laptop data inserted");
					}else {
						System.out.println("Laptop data not inserted ....something went wrong");
					}
					
			}
			
			break;
			
			case 2: {
			    System.out.println("Enter Laptop ID to Update:");
			    int id = scanner.nextInt();
			    scanner.nextLine(); // Consume the newline character

			    System.out.println("Enter Laptop new Name:");
			    String name = scanner.nextLine();

			    boolean b = dao.UpdateNameByID(name, id);
			    if (b) {
			        System.out.println("Laptop Name updated Successfully.");
			    } else {
			        System.out.println("Given ID not found.");
			    }
			} break;


			
	 
			
			case 3:{
				System.out.println("Enter Laptop id to delete");
				int id = scanner.nextInt();
				boolean b=dao.deleteLaptopById(id);
				if(b) {
					System.out.println("Data Deleted Successfully.");
				}else {
					System.out.println("given id not found");
				}
			}break;

			case 4:{
				System.out.println("enter user id to display");
				int id = scanner.nextInt();
				Laptop laptop=dao.getLaptopById(id);
				
				if(laptop!=null) {
				 	int id1  =  laptop.getId();
			    	String name  = laptop.getName();
			    	String color = laptop.getColor();
			    	int price  =   laptop.getPrice();
			    	LocalDate mfd = laptop.getMfd();
			    	
			    	System.out.println("----------------------");
			    	System.out.println("ID is "+ id1);
			    	System.out.println("name is "+ name);
			    	System.out.println("Color is "+ color);
			    	System.out.println("Price is "+ price);
			    	System.out.println("Manufacturing date is "+ mfd);
			    	System.out.println("----------------------");
				}else {
					System.out.println("given id is not found......");
				}
			}break;
			
			
					
			case 5:{
				List<Laptop> laptops=dao.getAllLaptops();
				
				for (Laptop laptop : laptops) {
					
					int id  =  laptop.getId();
			    	String name  = laptop.getName();
			    	String color = laptop.getColor();
			    	int price  =   laptop.getPrice();
			    	LocalDate mfd = laptop.getMfd();
			    	

			    	System.out.println("----------------------");
			    	System.out.println("ID is "+ id);
			    	System.out.println("name is "+ name);
			    	System.out.println("Color is "+ color);
			    	System.out.println("Price is "+ price);
			    	System.out.println("Manufacturing date is "+ mfd);
			    	System.out.println("----------------------");
				}
			}break;
			

			}
		}

	}

}
