package com.lab.invest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.invest.dao.InvestorDao;
import com.lab.invest.dao.StockPoolDao;
import com.lab.invest.dao.WatchListDao;
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
		return watchListDao.queryAll();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public WatchList getOne(@PathParam("id") Integer id) {
		WatchList watchList = watchListDao.get(id);
		// ÃöÁp°t¸m
		watchList.setInvestor(investorDao.get(watchList.getInvestid()));
		watchList.setStockPool(stockPoolDao.get(watchList.getStockpoolid()));
		
		return watchList;
	}
}
