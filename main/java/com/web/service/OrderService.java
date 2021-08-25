package com.web.service;

public class OrderService {
	private static String[] names = {"Water", "Coffee", "Milk", "Tea"}; 
	private static String[] pays = {"�{��", "�H�Υd"};
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
	
	/*
	 ["0", "1"] -> ["�{��", "�H�Υd"]
	 ["0"] -> ["�{��"]
	 ["1"] -> ["�H�Υd"]
	 * */
	public String[] getPayNames(String[] p_pays) {
		for(int i=0;i<p_pays.length;i++) {
			int id = Integer.parseInt(p_pays[i]);
			p_pays[i] = pays[id];
		}
		return p_pays;
	}
}
