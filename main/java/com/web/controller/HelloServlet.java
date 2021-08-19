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
		res.setCharacterEncoding("UTF-8"); // �^�����e���s�X
		res.getWriter().print("Hello Servlet"); // �^�������e
		res.getWriter().print(new Date());      // �^�������e
	}
	
}
