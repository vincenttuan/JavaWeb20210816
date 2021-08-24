package com.lab.invest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;

import com.lab.invest.model.StockPool;


public class StockPoolDao {
	private Connection conn = DBConn.conn;
	
	public List<StockPool> queryAll() {
		String sql = "select id, typeid, symbol, symbolname, warning, tdate from stockpool";
		List<StockPool> stockPools = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// OR-Mapping
			JdbcMapper<StockPool[]> mapper = JdbcMapperFactory.newInstance().newMapper(StockPool[].class);
			mapper.stream(rs).forEach(array -> stockPools.addAll(Arrays.asList(array)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockPools;
	}
	
	public StockPool get(Integer id) {
		String sql = "select id, typeid, symbol, symbolname, warning, tdate from stockpool where id=?";
		StockPool stockPool = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			// OR-Mapping
			JdbcMapper<StockPool> mapper = JdbcMapperFactory.newInstance().newMapper(StockPool.class);
			stockPool = mapper.stream(rs).findFirst().get();
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stockPool;
	}
}
