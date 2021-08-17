package com.web.service;

public class OrderService {
	private static String[] names = {"Water", "Coffee", "Milk", "Tea"}; 
	private static String[] pays = {"現金", "信用卡"};
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
	
	/*
	 ["0", "1"] -> ["現金", "信用卡"]
	 ["0"] -> ["現金"]
	 ["1"] -> ["信用卡"]
	 * */
	public String[] getPayNames(String[] p_pays) {
		for(int i=0;i<p_pays.length;i++) {
			int id = Integer.parseInt(p_pays[i]);
			p_pays[i] = pays[id];
		}
		return p_pays;
	}
}
