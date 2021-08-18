package com.lab.food.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab.food.service.FoodService;

@WebServlet(urlPatterns = "/lab/food/submit")
public class FoodSubmitController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		FoodService foodService = new FoodService();
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/lab/food/food_result.jsp");
		rd.forward(req, resp);
		
	}
	
}