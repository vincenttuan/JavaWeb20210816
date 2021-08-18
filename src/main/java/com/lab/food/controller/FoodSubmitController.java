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
		
		String food_id = req.getParameter("food_id");
		String food_qty = req.getParameter("food_qty");
		
		Integer id = 0;
		Integer qty = 0;
		
		// �ˬd�Ѽ�
		try {
			id = Integer.parseInt(food_id);
			qty = Integer.parseInt(food_qty);
		} catch (Exception e) {
			throw new ServletException("��ƿ�J���~");
		}
		
		// ����w�s
		FoodService foodService = new FoodService();
		boolean check = foodService.updateAmountById(id, qty);
		if(check == false) {
			throw new ServletException("�ʶR����, �ӫ~���s�b�ΰӫ~�w�s����...");
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/lab/food/food_result.jsp");
		rd.forward(req, resp);
		
	}
	
}
