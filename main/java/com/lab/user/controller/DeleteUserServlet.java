package com.lab.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab.user.dao.UserDao;

@WebServlet("/lab/user/delete")
public class DeleteUserServlet extends HttpServlet {
	private UserDao userDao = new UserDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int u_id = Integer.parseInt(req.getParameter("u_id"));
			userDao.delete(u_id);	
			RequestDispatcher rd = req.getRequestDispatcher("/form/user_form.jsp");
			req.setAttribute("users", userDao.queryAll(""));
			rd.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace(resp.getWriter());
		}
		
	}
	
}
