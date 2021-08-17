package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.service.OrderService;

@WebServlet(urlPatterns = "/controller/order")
public class OrderServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 使用 OrderService
		OrderService service = new OrderService();
		
		// 分派(dispatcher)並重導(forward) 到 /WEB-INF/jsp/order_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/order_result.jsp");
		rd.forward(req, resp);
		
	}
	
}
