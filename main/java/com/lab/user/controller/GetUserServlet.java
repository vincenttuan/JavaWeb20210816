package com.lab.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab.user.dao.User;
import com.lab.user.dao.UserDao;

@WebServlet("/lab/user/get")
public class GetUserServlet extends HttpServlet {
	private UserDao userDao = new UserDao();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		try {
			int u_id = Integer.parseInt(req.getParameter("u_id"));
			User user = userDao.get(u_id);
			
			RequestDispatcher rd = req.getRequestDispatcher("/form/user_form.jsp");
			req.setAttribute("user", user);
			req.setAttribute("users", userDao.queryAll(""));
			rd.forward(req, resp);
			
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter()); 
		}
		
	}
	
}
