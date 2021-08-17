package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 �g�@�� CalcServlet ��	
 �s������J : http://localhost:8080/JavaWeb20210816/controller/calc?h=170&w=60
 HTTP ��k : GET
 �����i�H�o�� : 20.76 
*/

@WebServlet(urlPatterns = { "/controller/calc" })
public class CalcServlet extends HttpServlet {

	private void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �ѨM����s�X���D�Х[�J��3��
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String h = req.getParameter("h");
		String w = req.getParameter("w");
		PrintWriter out = resp.getWriter();

		// �ˬd�Ѽ�
		if (h != null && w != null) {
			try {
				// �r����B�I��
				double double_h = Double.parseDouble(h);
				double double_w = Double.parseDouble(w);
				double bmi = double_w / Math.pow(double_h / 100, 2);
				out.print(String.format("h: %.1f w: %.1f bmi: %.2f", double_h, double_w, bmi));
			} catch (Exception e) {
				// �ഫ����
				out.print("Arg is not numeric: " + e);
			}
		} else {
			// �L�]�w�Ѽ�
			out.print("Args is null !");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}

}
