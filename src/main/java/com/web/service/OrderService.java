package com.web.service;

public class OrderService {
	
	// �p���`���B
	public double getTotal(int price, int amount, double discount) {
		double total = price * amount * discount;
		return total;
	}
	
}
