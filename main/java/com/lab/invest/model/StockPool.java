package com.lab.invest.model;

import java.util.Date;

public class StockPool {
	private Integer id;
	private Integer typeid;
	private String symbol;
	private String symbolname;
	private Integer warning;
	private Date tdate;
	
	public StockPool() {
		
	}
	
	public StockPool(Integer id, Integer typeid, String symbol, String symbolname, Integer warning, Date tdate) {
		this.id = id;
		this.typeid = typeid;
		this.symbol = symbol;
		this.symbolname = symbolname;
		this.warning = warning;
		this.tdate = tdate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSymbolname() {
		return symbolname;
	}

	public void setSymbolname(String symbolname) {
		this.symbolname = symbolname;
	}

	public Integer getWarning() {
		return warning;
	}

	public void setWarning(Integer warning) {
		this.warning = warning;
	}

	public Date getTdate() {
		return tdate;
	}

	public void setTdate(Date tdate) {
		this.tdate = tdate;
	}

	@Override
	public String toString() {
		return "StockPool [id=" + id + ", typeid=" + typeid + ", symbol=" + symbol + ", symbolname=" + symbolname
				+ ", warning=" + warning + ", tdate=" + tdate + "]";
	}
	
}
