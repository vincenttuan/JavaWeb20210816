package com.lab.invest.model;

import java.util.Date;

public class RealTimeStock {
	// 絃い戈癟
	private String symbol;
	private Double bid; // 禦基
	private Double ask; // 芥基
	private Double lastprice; // 程Θユ基
	private Double change; // 害禴
	private Double changePercent; // 害禴碩
	private Long volume; // 羆秖
	private Date transdate; // 程ユ丁
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public Double getBid() {
		return bid;
	}
	public void setBid(Double bid) {
		this.bid = bid;
	}
	public Double getAsk() {
		return ask;
	}
	public void setAsk(Double ask) {
		this.ask = ask;
	}
	public Double getLastprice() {
		return lastprice;
	}
	public void setLastprice(Double lastprice) {
		this.lastprice = lastprice;
	}
	public Double getChange() {
		return change;
	}
	public void setChange(Double change) {
		this.change = change;
	}
	public Double getChangePercent() {
		return changePercent;
	}
	public void setChangePercent(Double changePercent) {
		this.changePercent = changePercent;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public Date getTransdate() {
		return transdate;
	}
	public void setTransdate(Date transdate) {
		this.transdate = transdate;
	}
	
	
	

}
