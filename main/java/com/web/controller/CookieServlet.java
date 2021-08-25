package com.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/controller/cookie")
public class CookieServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// �]�m cookies
		String amount = req.getParameter("amount");
		// �]�w cookie ���
		Cookie cookie = new Cookie("amount", amount);
		cookie.setMaxAge(60); // 60��
		// �ǰe cookie ��Ƶ��s�����g�J�� client ���q����
		//cookie = new Cookie("amount", "100");
		resp.addCookie(cookie);
		
		// ���ɺ���
		RequestDispatcher rd = req.getRequestDispatcher("/form/cookie_form.jsp");
		rd.forward(req, resp);
	}
	
}
