package com.lab.user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lab.user.dao.UserDao;

@WebServlet("/lab/user/update")
public class UpdateUserServlet extends HttpServlet {
	private UserDao userDao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String u_id = req.getParameter("u_id");
		String u_username = req.getParameter("u_username");
		String u_password = req.getParameter("u_password");
		String u_priority = req.getParameter("u_priority");
		
		if(u_id != null && u_id.length() > 0) {
			// update
			
		} else {
			// create
			
		}
	}
	
}
