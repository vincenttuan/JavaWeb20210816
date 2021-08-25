package com.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/controller/session_clear")
public class SessionClearServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 取得當前 session
		HttpSession session = req.getSession(false);
		if(session != null) {
			session.invalidate();
		}
		
		// 重導網頁
		RequestDispatcher rd = req.getRequestDispatcher("/form/session_form.jsp");
		rd.forward(req, resp);

	}

}
