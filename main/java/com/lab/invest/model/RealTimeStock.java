package com.lab.invest.model;

import java.util.Date;

public class RealTimeStock {
	// �L���Y�ɸ�T
	private String symbol;
	private Double bid; // �R��
	private Double ask; // ���
	private Double lastprice; // �̫ᦨ���
	private Long volume; // �`�q
	private Date transdate; // �̫����ɶ�
	
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
