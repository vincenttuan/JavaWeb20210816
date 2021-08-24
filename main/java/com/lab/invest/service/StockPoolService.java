package com.lab.invest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.invest.dao.StockPoolDao;
import com.lab.invest.model.StockPool;

@Path("/stockpool")
public class StockPoolService {
	
	private StockPoolDao stockPoolDao = new StockPoolDao();
	
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<StockPool> queryAll() {
		return stockPoolDao.queryAll();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public StockPool getOne(@PathParam("id") Integer id) {
		return stockPoolDao.get(id);
	}
}
