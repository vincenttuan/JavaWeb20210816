package com.web.service;

public class OrderService {
	private static String[] names = {"Water", "Coffee", "Milk", "Tea"}; 
	
	// �p���`���B
	public double getTotal(int price, int amount, double discount) {
		double total = price * amount * discount;
		return total;
	}
	
	// �ھ� id �� name
	public String getNameById(int id) {
		String name = names[id];
		return name;
	}
}
