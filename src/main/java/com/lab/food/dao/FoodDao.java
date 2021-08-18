package com.lab.food.dao;

import java.util.ArrayList;
import java.util.List;

public class FoodDao {
	
	// DB-Table
	private static List<Food> foods;
	
	static {
		foods = new ArrayList<Food>();
		foods.add(new Food(1, "�v����", 20, 100));
		foods.add(new Food(2, "���z", 30, 50));
		foods.add(new Food(3, "�{����", 50, 30));
	}
	
	// CRUD
	public List<Food> findAll() {
		return foods;
	}
	
	public Food getFoodById(Integer id) {
		return foods.stream().filter(f -> f.getId() == id).findFirst().get();
	}
	
	// id : �ӫ~�N��
	// qty : ���O�ƶq
	public boolean updateAmount(Integer id, Integer qty) {
		Food food = getFoodById(id);
		food.setAmount(food.getAmount() - qty);
		return true;
	}
	
}
