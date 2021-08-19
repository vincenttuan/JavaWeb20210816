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

@WebServlet(urlPatterns = "/controller/session")
public class SessionServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String amount = req.getParameter("amount");
		
		// �إ� session
		HttpSession session = req.getSession();
		// �P�_ session �ݩʤ��O�_�� amount_list ��� ?
		List<String> amount_list = null;
		if (session.getAttribute("amount_list") == null) {
			amount_list = new ArrayList<>();
		} else {
			amount_list = (List<String>) session.getAttribute("amount_list");
		}
		// �N amount ��ƥ[�J�� amount_list
		amount_list.add(amount);
		// �s�J session �ó]�w amount_list �ݩʸ��
		session.setAttribute("amount_list", amount_list);

		// ���ɺ���
		RequestDispatcher rd = req.getRequestDispatcher("/form/session_form.jsp");
		req.setAttribute("session_id", session.getId());
		req.setAttribute("session_amount_list", session.getAttribute("amount_list"));
		rd.forward(req, resp);

	}

}
