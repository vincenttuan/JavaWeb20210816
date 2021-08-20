package com.lab.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;

public class UserDao {
	private static Connection conn;
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
	
	public List<User> queryAll() throws Exception {
		// 查詢資料表
		String sql = "select u_id, u_username, u_password, u_priority, u_createtime from user";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql); 
		
		// OR-Mapping 到 users 集合
		List<User> users = new ArrayList<>();
		JdbcMapper<User[]> mapper = JdbcMapperFactory.newInstance().newMapper(User[].class);
		mapper.stream(rs).forEach(user_array -> users.addAll(Arrays.asList(user_array)));
		
		// 關閉物件
		rs.close();
		stmt.close();
		
		return users;
	}
}
