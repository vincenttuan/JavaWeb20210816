package com.lab.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	
	// create
	public int create(User user) throws Exception {
		String sql = "Insert into user(u_username, u_password, u_priority) values(?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, user.getU_username());
			pstmt.setString(2, user.getU_password());
			pstmt.setInt(3, user.getU_priority());
			return pstmt.executeUpdate();
		}
	}
	
	// update
	public int update(User user) throws Exception {
		String sql = "Update user set u_username=?, u_password=?, u_priority=? where u_id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, user.getU_username());
			pstmt.setString(2, user.getU_password());
			pstmt.setInt(3, user.getU_priority());
			pstmt.setInt(4, user.getU_id());
			return pstmt.executeUpdate();
		}
	}
	
	// delete
	public int delete(Integer u_id) throws Exception {
		String sql = "Delete from user where u_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, u_id);
			return pstmt.executeUpdate();
		}
	}
	
	// get
	public User get(Integer u_id) throws Exception {
		String sql = "select u_id, u_username, u_password, u_priority, u_createtime from user " +
					 "where u_id = ?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, u_id);
			try(ResultSet rs = pstmt.executeQuery();) {
				if(rs.next()) {
					JdbcMapper<User> mapper = JdbcMapperFactory.newInstance().newMapper(User.class);
					return mapper.stream(rs).findAny().get();
				}
				return null;
			}
		}
		
	}
	
	
	// query
	public List<User> queryAll(String u_username_keyword) throws Exception {
		// 查詢資料表
		String sql = "select u_id, u_username, u_password, u_priority, u_createtime from user " +
				     "where u_username like ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		if(u_username_keyword == null) {
			u_username_keyword = "";
		} 
		u_username_keyword = "%" + u_username_keyword.trim() + "%";
		pstmt.setString(1, u_username_keyword);
		ResultSet rs = pstmt.executeQuery(); 
		
		// OR-Mapping 到 users 集合
		List<User> users = new ArrayList<>();
		JdbcMapper<User[]> mapper = JdbcMapperFactory.newInstance().newMapper(User[].class);
		mapper.stream(rs).forEach(user_array -> users.addAll(Arrays.asList(user_array)));
		
		// 關閉物件
		rs.close();
		pstmt.close();
		
		return users;
	}
}
