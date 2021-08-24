package com.lab.invest.model;

import java.util.Date;

public class WatchList {
	private Integer id;
	private Integer investid; // investor's id
	private Integer stockpoolid;
	private Date tdate;
	
	public WatchList() {
		
	}
	
	public WatchList(Integer id, Integer investid, Integer stockpoolid, Date tdate) {
		this.id = id;
		this.investid = investid;
		this.stockpoolid = stockpoolid;
		this.tdate = tdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getInvestid() {
		return investid;
	}

	public void setInvestid(Integer investid) {
		this.investid = investid;
	}

	public Integer getStockpoolid() {
		return stockpoolid;
	}

	public void setStockpoolid(Integer stockpoolid) {
		this.stockpoolid = stockpoolid;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	@Override
	public String toString() {
		return "WatchList [id=" + id + ", investid=" + investid + ", stockpoolid=" + stockpoolid + ", tdate=" + tdate
				+ "]";
	}
	
	
}
