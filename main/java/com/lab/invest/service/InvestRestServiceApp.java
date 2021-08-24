package com.lab.invest.service;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class InvestRestServiceApp extends Application {

	// ���U�A�����O
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new LinkedHashSet<>();
		classes.add(InvestorService.class);
		classes.add(StockPoolService.class);
		classes.add(WatchListService.class);
		classes.add(TransactionLogService.class);
		return classes;
	}

	
}
