package com.lab.food.dao;

public class Food {
	private Integer id;
	private String name;
	private Integer price;
	private Integer amount;
	
	public Food() {
		
	}
	
	public Food(Integer id, String name, Integer price, Integer amount) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
	
	
}
