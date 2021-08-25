package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 寫一個 CalcServlet 當	
 瀏覽器輸入 : http://localhost:8080/JavaWeb20210816/controller/calc?h=170&w=60
 HTTP 方法 : GET
 網頁可以得到 : 20.76 
*/

@WebServlet(urlPatterns = { "/controller/calc" })
public class CalcServlet extends HttpServlet {

	private void doHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 解決中文編碼問題請加入此3行
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		String h = req.getParameter("h");
		String w = req.getParameter("w");
		PrintWriter out = resp.getWriter();

		// 檢查參數
		if (h != null && w != null) {
			try {
				// 字串轉浮點數
				double double_h = Double.parseDouble(h);
				double double_w = Double.parseDouble(w);
				double bmi = double_w / Math.pow(double_h / 100, 2);
				out.print(String.format("h: %.1f w: %.1f bmi: %.2f", double_h, double_w, bmi));
			} catch (Exception e) {
				// 轉換失敗
				out.print("Arg is not numeric: " + e);
			}
		} else {
			// 無設定參數
			out.print("Args is null !");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandler(req, resp);
	}

}
