package com.web.service;

public class OrderService {
	private static String[] names = {"Water", "Coffee", "Milk", "Tea"}; 
	
	// 計算總金額
	public double getTotal(int price, int amount, double discount) {
		double total = price * amount * discount;
		return total;
	}
	
	// 根據 id 取 name
	public String getNameById(int id) {
		String name = names[id];
		return name;
	}
}
