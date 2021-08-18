package com.lab.food.dao;

import java.util.ArrayList;
import java.util.List;

public class FoodDao {
	
	// DB-Table
	private static List<Food> foods;
	
	static {
		foods = new ArrayList<Food>();
		foods.add(new Food(1, "洋芋片", 20, 100));
		foods.add(new Food(2, "豆干", 30, 50));
		foods.add(new Food(3, "魷魚絲", 50, 30));
	}
	
	// CRUD
	public List<Food> findAll() {
		return foods;
	}
	
	public Food getFoodById(Integer id) {
		return foods.stream().filter(f -> f.getId() == id).findFirst().get();
	}
	
	// id : 商品代號
	// qty : 消費數量
	public boolean updateAmount(Integer id, Integer qty) {
		Food food = getFoodById(id);
		food.setAmount(food.getAmount() - qty);
		return true;
	}
	
}
