package com.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionServiceListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// �إߤ@�� Application scope ���ܼƨӦs����
		ServletContext appplication = se.getSession().getServletContext();
		int count = 0;
		if(appplication.getAttribute("count") != null) {
			count = Integer.parseInt(appplication.getAttribute("count").toString());
		}
		count++;
		appplication.setAttribute("count", count);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		ServletContext appplication = se.getSession().getServletContext();
		int count = Integer.parseInt(appplication.getAttribute("count").toString());
		count--;
		appplication.setAttribute("count", count);
	}
	
}
