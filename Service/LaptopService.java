package com.jspider.JDBC_CURD_Test.Service;


import java.util.Collections;
import java.util.List;

import com.jspider.JDBC_CURD_Test.DAO.LaptopDAO;
import com.jspider.JDBC_CURD_Test.DTO.Laptop;


public class LaptopService {


		LaptopDAO dao = new LaptopDAO();
		
		public Laptop saveUserService(Laptop laptop) {
			int year=laptop.getMfd().getYear();
			int price  = laptop.getPrice();
			
			if((year>2011 && year<2023)&& (price>32000 && price < 90000) ){
				return dao.saveLaptopDao(laptop);
			}else {
				System.out.println("mfd year must be greator than 2011 and less than 2023");
				System.out.println("price must be greator than 32000 and less than 90000");
				return null;
			}
		}
		

	}


