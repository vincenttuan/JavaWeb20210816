package com.web.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class HelloServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		res.setCharacterEncoding("UTF-8"); // 回應內容的編碼
		res.getWriter().print("Hello Servlet"); // 回應的內容
		res.getWriter().print(new Date());      // 回應的內容
	}
	
}
