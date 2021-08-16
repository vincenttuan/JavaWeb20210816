package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/controller/add")
public class AddServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		if(x != null && y != null) {
			try {
				int int_x = Integer.parseInt(x);
				int int_y = Integer.parseInt(y);
				int int_z = int_x + int_y;
				out.print(int_z);
			} catch (Exception e) {
				out.print("Args error : " + e);
			}
		} else {
			String z = x + y;
			out.print(z);
		}
		
	}
	
}
