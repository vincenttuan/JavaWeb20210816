package com.lab.invest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.invest.dao.InvestorDao;
import com.lab.invest.dao.StockPoolDao;
import com.lab.invest.dao.WatchListDao;
import com.lab.invest.model.TransactionLog;
import com.lab.invest.model.WatchList;

@Path("/watchlist")
public class WatchListService {
	
	private WatchListDao watchListDao = new WatchListDao();
	private InvestorDao investorDao = new InvestorDao();
	private StockPoolDao stockPoolDao = new StockPoolDao();
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<WatchList> queryAll() {
		// 關聯配置
		List<WatchList> watchLists = watchListDao.queryAll();
		for(WatchList watchList : watchLists) {
			watchList.setInvestor(investorDao.get(watchList.getInvestid()));
			watchList.setStockPool(stockPoolDao.get(watchList.getStockpoolid()));
		}
		return watchLists;
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public WatchList getOne(@PathParam("id") Integer id) {
		WatchList watchList = watchListDao.get(id);
		// 關聯配置
		watchList.setInvestor(investorDao.get(watchList.getInvestid()));
		watchList.setStockPool(stockPoolDao.get(watchList.getStockpoolid()));
		
		return watchList;
	}
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String create(WatchList watchList) {
		int rowcount = watchListDao.create(watchList);
		return rowcount + "";
	}
	
}
