package com.lab.invest.service;

import java.util.Calendar;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

@Path("/price")
public class PriceService {
	@Path("/histquotes/{symbol:.+}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<HistoricalQuote> queryHistQuotes(@PathParam("symbol") String symbol) {
        List<HistoricalQuote> histQuotes = null;
        try {
            Calendar from = Calendar.getInstance();
            Calendar to = Calendar.getInstance();
            from.add(Calendar.MONTH, -3);

            Stock google = YahooFinance.get(symbol);
            histQuotes = google.getHistory(from, to, Interval.DAILY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return histQuotes;
    }
}
