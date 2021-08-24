package com.lab.invest.service;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.invest.dao.InvestorDao;
import com.lab.invest.model.Investor;

@Path("/investor")
public class InvestorService {
	
	private InvestorDao investorDao = new InvestorDao();
	
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
		return investorDao.get(id);
	}
	
	
}
