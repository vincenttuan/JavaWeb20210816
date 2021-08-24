package com.lab.invest.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	public static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String jdbcUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
			String username = "root";
			String password = "12345678";
			conn = DriverManager.getConnection(jdbcUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}
}
