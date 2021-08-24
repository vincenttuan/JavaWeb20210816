package com.lab.invest.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;

import com.lab.invest.model.Investor;

public class InvestorDao {
	private Connection conn = DBConn.conn;
	
	public List<Investor> queryAll() {
		String sql = "select id, username, email, tdate from investor";
		List<Investor> investors = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// OR-Mapping
			JdbcMapper<Investor[]> mapper = JdbcMapperFactory.newInstance().newMapper(Investor[].class);
			mapper.stream(rs).forEach(array -> investors.addAll(Arrays.asList(array)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return investors;
	}
}
