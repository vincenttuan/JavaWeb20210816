package com.lab.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab.user.dao.User;
import com.lab.user.dao.UserDao;

@WebServlet("/lab/user/query")
public class QueryUserServlet extends HttpServlet {
	private UserDao userDao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u_username_keyword = req.getParameter("u_username_keyword");
		List<User> users = null;
		try {
			users = userDao.queryAll(u_username_keyword);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/form/user_form.jsp");
		req.setAttribute("users", users);
		rd.forward(req, resp);
		
	}
	
}
