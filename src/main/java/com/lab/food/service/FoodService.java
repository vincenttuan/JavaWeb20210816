package com.lab.food.service;

import java.util.List;

import com.lab.food.dao.Food;
import com.lab.food.dao.FoodDao;

public class FoodService {
	
	private FoodDao foodDao = new FoodDao();
	
	// 查詢所有庫存資料
	public List<Food> queryFoods() {
		return foodDao.findAll();
	}
	
}
