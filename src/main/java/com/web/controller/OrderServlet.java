package com.web.controller;

import java.io.IOException;
import java.util.Arrays;

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
		// 取得 form data
		String p_id = req.getParameter("p_id"); 
		String p_price = req.getParameter("p_price"); 
		String p_amount = req.getParameter("p_amount"); 
		String[] p_pays = req.getParameterValues("p_pay");
		String p_discount = req.getParameter("p_discount");
		String p_memo = req.getParameter("p_memo");
		
		// 使用 OrderService
		OrderService service = new OrderService();
		// 計算總金額
		int price = Integer.parseInt(p_price);
		int amount = Integer.parseInt(p_amount);
		double discount = Double.parseDouble(p_discount);
		double total = service.getTotal(price, amount, discount);
		// 取得商品名稱
		int id = Integer.parseInt(p_id);
		String p_name = service.getNameById(id);
		// 取得付款名稱
		String[] p_payNames = service.getPayNames(p_pays);
		
		// 分派(dispatcher)並重導(forward) 到 /WEB-INF/jsp/order_result.jsp
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/order_result.jsp");
		// 設定要傳送到 jsp 的資料
		req.setAttribute("p_name", p_name);
		req.setAttribute("p_payNames", Arrays.toString(p_payNames));
		req.setAttribute("total", total);
		rd.forward(req, resp);
		
	}
	
}

