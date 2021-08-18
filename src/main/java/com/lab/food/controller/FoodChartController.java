package com.lab.food.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab.food.dao.Food;
import com.lab.food.service.FoodService;

@WebServlet(urlPatterns = "/lab/food/chart")
public class FoodChartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FoodService foodService = new FoodService();
		List<Food> foods = foodService.queryFoods();
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/lab/food/food_chart.jsp");
		req.setAttribute("foods", foods);
		rd.forward(req, resp);
		
	}
	
}
