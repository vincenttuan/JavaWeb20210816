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

import com.lab.invest.model.WatchList;


public class WatchListDao {
	private Connection conn = DBConn.conn;
	
	public List<WatchList> queryByInvestorId(Integer investid) {
		String sql = "select id, investid, stockpoolid, tdate from watchlist where investid = " + investid;
		List<WatchList> watchLists = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// OR-Mapping
			JdbcMapper<WatchList[]> mapper = JdbcMapperFactory.newInstance().newMapper(WatchList[].class);
			mapper.stream(rs).forEach(array -> watchLists.addAll(Arrays.asList(array)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return watchLists;
	}
	
	public List<WatchList> queryAll() {
		String sql = "select id, investid, stockpoolid, tdate from watchlist";
		List<WatchList> watchLists = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// OR-Mapping
			JdbcMapper<WatchList[]> mapper = JdbcMapperFactory.newInstance().newMapper(WatchList[].class);
			mapper.stream(rs).forEach(array -> watchLists.addAll(Arrays.asList(array)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return watchLists;
	}
	
	public WatchList get(Integer id) {
		String sql = "select id, investid, stockpoolid, tdate from watchlist where id=?";
		WatchList watchList = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			// OR-Mapping
			JdbcMapper<WatchList> mapper = JdbcMapperFactory.newInstance().newMapper(WatchList.class);
			watchList = mapper.stream(rs).findFirst().get();
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return watchList;
	}
}
