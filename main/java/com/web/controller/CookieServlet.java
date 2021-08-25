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
		// 設置 cookies
		String amount = req.getParameter("amount");
		// 設定 cookie 資料
		Cookie cookie = new Cookie("amount", amount);
		cookie.setMaxAge(60); // 60秒
		// 傳送 cookie 資料給瀏覽器寫入到 client 的電腦中
		//cookie = new Cookie("amount", "100");
		resp.addCookie(cookie);
		
		// 重導網頁
		RequestDispatcher rd = req.getRequestDispatcher("/form/cookie_form.jsp");
		rd.forward(req, resp);
	}
	
}
