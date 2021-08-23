package com.lab.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;

import com.lab.user.dao.User;
import com.lab.user.dao.UserDao;

@WebServlet("/lab/user/update")
public class UpdateUserServlet extends HttpServlet {
	private UserDao userDao = new UserDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ��Ʊ���
		String u_id = req.getParameter("u_id");
		String u_username = req.getParameter("u_username");
		String u_password = req.getParameter("u_password");
		String u_priority = req.getParameter("u_priority");
		
		// ��ƳB�z
		Integer id = (u_id == null || u_id.trim().length() == 0) ? 0 : Integer.parseInt(u_id);
		String username = u_username;
		String password = new Base64().encodeAsString(u_password.getBytes()); // �K�X�s�X
		Integer priority = (u_priority == null || u_priority.trim().length() == 0) ? 0 : Integer.parseInt(u_priority);
		
		// �إ� User ����
		User user = new User();
		user.setU_id(id);
		user.setU_username(username);
		user.setU_password(password);
		user.setU_priority(priority);
		
		// create or update
		try {
			if(u_id != null && u_id.length() > 0) {
				// update
				userDao.update(user);
			} else {
				// create
				userDao.create(user);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		// ���ɨ�d�߸��|, �]���o�˥i�H�@�s�W�����W�d�ݵ��G
		RequestDispatcher rd = req.getRequestDispatcher("/lab/user/query");
		rd.forward(req, resp);
	}
	
}
