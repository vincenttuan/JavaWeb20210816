package com.web.service;

public class OrderService {
	
	// ­pºâÁ`ª÷ÃB
	public double getTotal(int price, int amount, double discount) {
		double total = price * amount * discount;
		return total;
	}
	
}
