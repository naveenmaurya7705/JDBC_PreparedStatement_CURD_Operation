package com.jspider.JDBC_CURD_Test.DTO;

import java.time.LocalDate;

public class Laptop {
	
	private int id ;
	private String name ;
	private String color;
	private int price;
	private LocalDate mfd;
	
	
	
	public Laptop() {
		super();
		
	}



	public Laptop(int id, String name, String color, int price, LocalDate mfd) {
		super();
		this.id = id;
		this.name = name;
		this.color = color;
		this.price = price;
		this.mfd = mfd;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public LocalDate getMfd() {
		return mfd;
	}



	public void setMfd(LocalDate mfd) {
		this.mfd = mfd;
	}

    




	
}
