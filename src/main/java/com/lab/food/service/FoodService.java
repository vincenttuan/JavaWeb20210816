package com.lab.food.service;

import java.util.List;

import com.lab.food.dao.Food;
import com.lab.food.dao.FoodDao;

public class FoodService {
	
	private FoodDao foodDao = new FoodDao();
	
	// �d�ߩҦ��w�s���
	public List<Food> queryFoods() {
		return foodDao.findAll();
	}
	
}
