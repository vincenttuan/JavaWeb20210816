package com.lab.invest.model;

import java.util.Date;

public class Portfolio {
	private Integer id;
	private Integer investid;
	private Integer stockpoolid;
	private Double price;
	private Integer amount;
	private Date tdate;
	
	public Portfolio() {
		
	}
	
	public Portfolio(Integer id, Integer investid, Integer stockpoolid, Double price, Integer amount,
			Date tdate) {
		this.id = id;
		this.investid = investid;
		this.stockpoolid = stockpoolid;
		this.price = price;
		this.amount = amount;
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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	@Override
	public String toString() {
		return "Portfolio [id=" + id + ", investid=" + investid + ", stockpoolid=" + stockpoolid + ", price=" + price
				+ ", amount=" + amount + ", tdate=" + tdate + "]";
	}

	
}
