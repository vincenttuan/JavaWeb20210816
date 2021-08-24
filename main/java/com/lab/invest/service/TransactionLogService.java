package com.lab.invest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.invest.dao.InvestorDao;
import com.lab.invest.dao.StockPoolDao;
import com.lab.invest.dao.TransactionLogDao;
import com.lab.invest.model.TransactionLog;

@Path("/transactionlog")
public class TransactionLogService {
	
	private TransactionLogDao transactionLogDao = new TransactionLogDao();
	private InvestorDao investorDao = new InvestorDao();
	private StockPoolDao stockPoolDao = new StockPoolDao();
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TransactionLog> queryAll() {
		// 關聯配置
		List<TransactionLog> transactionLogs = transactionLogDao.queryAll();
		for(TransactionLog transactionLog : transactionLogs) {
			transactionLog.setInvestor(investorDao.get(transactionLog.getInvestid()));
			transactionLog.setStockPool(stockPoolDao.get(transactionLog.getStockpoolid()));
		}
		return transactionLogs;
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TransactionLog getOne(@PathParam("id") Integer id) {
		TransactionLog transactionLog = transactionLogDao.get(id);
		// 關聯配置
		transactionLog.setInvestor(investorDao.get(transactionLog.getInvestid()));
		transactionLog.setStockPool(stockPoolDao.get(transactionLog.getStockpoolid()));
		
		return transactionLog;
	}
}
