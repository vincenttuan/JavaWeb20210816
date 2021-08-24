package com.lab.invest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.invest.dao.WatchListDao;
import com.lab.invest.model.WatchList;

@Path("/watchlist")
public class WatchListService {
	
	private WatchListDao watchListDao = new WatchListDao();
	
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
		return watchListDao.get(id);
	}
}
