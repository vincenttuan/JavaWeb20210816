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
	
	// ����w�s
	public boolean updateAmountById(Integer id, Integer qty) {
		// �ھ� id ��� food ����
		Food food = foodDao.getFoodById(id);
		if(food == null) {
			return false;
		} else {
			if(food.getAmount() >= qty) { // �w�s�ƶq >= �ʶR�ƶq
				foodDao.updateAmount(id, qty);
				return true;
			} else {
				return false;
			}
		}
	}
	
}
