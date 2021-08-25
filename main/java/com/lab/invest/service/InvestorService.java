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
import com.lab.invest.dao.WatchListDao;
import com.lab.invest.model.Investor;
import com.lab.invest.model.TransactionLog;
import com.lab.invest.model.WatchList;

@Path("/investor")
public class InvestorService {
	
	private InvestorDao investorDao = new InvestorDao();
	private WatchListDao watchListDao = new WatchListDao();
	private TransactionLogDao transactionLogDao = new TransactionLogDao();
	private StockPoolDao stockPoolDao = new StockPoolDao();
	
	@Path("/hello")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello john";
	}
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Investor> queryAll() {
		return investorDao.queryAll();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Investor getOne(@PathParam("id") Integer id) {
		Investor investor = investorDao.get(id);
		
		// 加入關聯資訊
		List<WatchList> watchLists = watchListDao.queryByInvestorId(investor.getId());
		watchLists.stream().forEach(w -> w.setStockPool(stockPoolDao.get(w.getStockpoolid())));
		investor.setWatchLists(watchLists);
		
		List<TransactionLog> transactionLogs = transactionLogDao.queryByInvestorId(investor.getId());
		transactionLogs.stream().forEach(t -> t.setStockPool(stockPoolDao.get(t.getStockpoolid())));
		investor.setTransactionLogs(transactionLogs);
		
		return investor;
	}
	
	
}
