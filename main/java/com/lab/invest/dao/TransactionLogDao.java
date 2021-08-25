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

import com.lab.invest.model.TransactionLog;


public class TransactionLogDao {
	private Connection conn = DBConn.conn;
	
	public List<TransactionLog> queryByInvestorId(Integer investid) {
		String sql = "select id, investid, stockpoolid, bs, price, amount, tdate from transactionlog where investid=" + investid;
		List<TransactionLog> transactionLogs = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// OR-Mapping
			JdbcMapper<TransactionLog[]> mapper = JdbcMapperFactory.newInstance().newMapper(TransactionLog[].class);
			mapper.stream(rs).forEach(array -> transactionLogs.addAll(Arrays.asList(array)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionLogs;
	}
	
	public List<TransactionLog> queryAll() {
		String sql = "select id, investid, stockpoolid, bs, price, amount, tdate from transactionlog";
		List<TransactionLog> transactionLogs = new ArrayList<>();
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			// OR-Mapping
			JdbcMapper<TransactionLog[]> mapper = JdbcMapperFactory.newInstance().newMapper(TransactionLog[].class);
			mapper.stream(rs).forEach(array -> transactionLogs.addAll(Arrays.asList(array)));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionLogs;
	}
	
	public TransactionLog get(Integer id) {
		String sql = "select id, investid, stockpoolid, bs, price, amount, tdate from transactionlog where id=?";
		TransactionLog transactionLog = null;
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			// OR-Mapping
			JdbcMapper<TransactionLog> mapper = JdbcMapperFactory.newInstance().newMapper(TransactionLog.class);
			transactionLog = mapper.stream(rs).findFirst().get();
			
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return transactionLog;
	}
}
