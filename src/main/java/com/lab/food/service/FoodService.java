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
	
	// 根據 id 取得 food 物件
	public Food getFood(Integer id) {
		return foodDao.getFoodById(id);
	}
	
	// 計算小記
	public int getTotal(Integer id, Integer qty) {
		Food food = foodDao.getFoodById(id);
		if(food == null) {
			return 0;
		} else {
			return food.getPrice() * qty;
		}
	}
	
	// 扣抵庫存
	public boolean updateAmountById(Integer id, Integer qty) {
		// 根據 id 找到 food 物件
		Food food = foodDao.getFoodById(id);
		if(food == null) {
			return false;
		} else {
			if(food.getAmount() >= qty) { // 庫存數量 >= 購買數量
				foodDao.updateAmount(id, qty);
				return true;
			} else {
				return false;
			}
		}
	}
	
}
