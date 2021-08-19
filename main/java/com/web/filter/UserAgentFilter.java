package com.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns = {"/form/*", "/controller/*"})
public class UserAgentFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		// 過濾 User-Agent
		if(req.getHeader("User-Agent").contains("Mozilla")) {
			// 繼續往前
			chain.doFilter(req, res);
		} else {
			res.getWriter().print("fordidden");
			return;
		}
				
	}
	
}
