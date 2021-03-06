<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<meta charset="UTF-8">
	<title>Invest Form</title>
	<script>
		// 投資人 id
    	var investorid = 2;
    
		// 公用程式
		String.format = function () {
	        if (arguments.length == 0)
	            return null;
	        var str = arguments[0];
	        for (var i = 1; i < arguments.length; i++) {
	            var re = new RegExp('\\{' + (i - 1) + '\\}', 'gm');
	            str = str.replace(re, arguments[i]);
	        }
	        return str;
	    };
	    
	    function numberFormat(nStr) {
	        nStr += '';
	        x = nStr.split('.');
	        x1 = x[0];
	        x2 = x.length > 1 ? '.' + x[1] : '';
	        var rgx = /(\d+)(\d{3})/;
	        while (rgx.test(x1)) {
	            x1 = x1.replace(rgx, '$1' + ',' + '$2');
	        }
	        return x1 + x2;
	    }
		
	    function buySell(bs, stockpoolid, price) {
	    	console.log("investorid: " + investorid + ", bs: " + bs + ", stockpoolid: " + stockpoolid + ", price: " + price);
	    	var amount = 0;
	    	switch(bs) {
	    		case 1:
	    			amount = prompt("買進數量", "1000");
	    			console.log(amount);
	    			break;
	    		case 2:
	    			amount = prompt("賣出數量", "1000");
	    			console.log(amount);
	    			break;
	    	}
	    	
	    	var obj = new Object();
	    	obj.investid    = investorid;
	    	obj.stockpoolid = stockpoolid;
	    	obj.bs          = (bs == 1) ? 'B' : 'S';
	    	obj.price       = price;
	    	obj.amount      = amount;
	    	
	    	var jsonStr = JSON.stringify(obj);
	    	
	    	$.ajax({
	    		url: '/JavaWeb20210816/rest/transactionlog/',
	    		type: 'POST',
	    		contentType: 'application/json; charset=utf-8',
	    		data: jsonStr,
	    		async: true,
	    		cache: false,
	    		processData: false,
	    		success: function(result) {  // server 回傳的結果
	    			console.log(result);
	    			// 抓取網頁最新資料
	    			getInvestorData();
	    		}
	    	});
	    	
	    }
	    
	    function deleteItem(id) {
	    	$.ajax({
	    		url: '/JavaWeb20210816/rest/transactionlog/' + id,
	    		type: 'DELETE',
	    		async: true,
	    		cache: false,
	    		processData: false,
	    		success: function(result) {  // server 回傳的結果
	    			console.log(result);
	    			// 抓取網頁最新資料
	    			getInvestorData();
	    		}
	    	});
	    }
	    
	    function addWatchList() {
	    	var stockpoolid = $('#selectList').val();
	    	var obj = new Object();
	    	obj.investid    = investorid;
	    	obj.stockpoolid = stockpoolid;
	    	
	    	var jsonStr = JSON.stringify(obj);
	    	
	    	$.ajax({
	    		url: '/JavaWeb20210816/rest/watchlist/',
	    		type: 'POST',
	    		contentType: 'application/json; charset=utf-8',
	    		data: jsonStr,
	    		async: true,
	    		cache: false,
	    		processData: false,
	    		success: function(result) {  // server 回傳的結果
	    			console.log(result);
	    			// 抓取網頁最新資料
	    			getInvestorData();
	    		}
	    	});
	    }
	    
	    function getStockPoolList() {
	    	var url = '/JavaWeb20210816/rest/stockpool/';
	    	$.get(url, function(datas, status) {
	    		$.each(datas, function(i, item) {
	    			$('#selectList').append(new Option(item.symbol + ' ' + item.symbolname, item.id));
	    		});
	    	});
	    }
	    
	    function getInvestorData() {
			var url = '/JavaWeb20210816/rest/investor/' + investorid;
			$.get(url, function(datas, status) { // datas : 回傳的 json 資料, status : 連線狀態
				console.log(status);
				console.log(datas);
				//-- 歡迎訊息 ------------------------------------
				$('#username').text(datas.username);
				$('#email').text(datas.email);
				//-- 我的交易紀錄 ---------------------------------
				$('#myTransTable tbody > tr').remove(); // 先將畫面暫存資料清除
				$.each(datas.transactionLogs, function(i, item) { 
					var html = '<tr><td>{0}</td><td>{1}</td><td>{2}</td><td nowrap>{3}</td><td>{4}</td><td>{5}</td><td nowrap>{6}</td><td nowrap>{7}</td></tr>';
					$('#myTransTable').append(
						String.format(html, item.id, item.bs, item.stockPool.symbol, item.stockPool.symbolname, item.amount, item.price, item.tdate, '<input type="button" value="刪除" onclick="deleteItem(' + item.id + ')" />')		
					);
				});
				//-- 我的 Watch List ----------------------------
				$('#myWatchTable tbody > tr').remove(); // 先將畫面暫存資料清除
				$.each(datas.watchLists, function(i, item) { 
					var html = '<tr><td>{0}</td><td>{1}</td><td>{2}</td><td nowrap>{3}</td><td>{4}</td><td style="color:{12}" align="right">{5}</td><td style="color:{12}" align="right">{6}</td><td style="color:{12}" align="right">{7}</td><td style="color:{12}" align="right">{8}</td><td style="color:{12}" align="right">{9}</td><td align="right">{10}</td><td nowrap>{11}</td><td nowrap>{13}</td><td nowrap>{14}</td></tr>';
					$('#myWatchTable').append(
						String.format(html, item.id, item.stockPool.typeid, '<span title="按我一下可以看K線圖" style="cursor:pointer" onclick="queryHistQuotes(\'' + item.stockPool.symbol + '\')">' + item.stockPool.symbol + '</span>', item.stockPool.symbolname, item.stockPool.warning, 
								            item.realTimeStock.bid, item.realTimeStock.ask, item.realTimeStock.lastprice, item.realTimeStock.change, item.realTimeStock.changePercent, numberFormat(item.realTimeStock.volume), item.realTimeStock.transdate, (item.realTimeStock.change >= 0)?'red':'#005100',
								            '<input type="button" value="買" onclick="buySell(1, ' + item.stockPool.id + ', ' + item.realTimeStock.lastprice + ')" />', '<input type="button" value="賣" onclick="buySell(2, ' + item.stockPool.id + ', ' + item.realTimeStock.lastprice + ')" />')		
					);
				});
				
			});
		}
	    
	    // JQuery 程式進入點
		$(document).ready(function() {
			getInvestorData();
			getStockPoolList();
		});
	</script>
</head>
<body style="padding: 15px">
	Hello <span id="username"></span> <span id="email"></span> 
	<p />
	我的交易紀錄
	<p />
	<table id="myTransTable" class="pure-table pure-table-bordered">
	    <thead>
	        <tr>
	            <th nowrap>id</th>
	            <th nowrap>買賣</th>
	            <th nowrap>代號</th>
	            <th nowrap>名稱</th>
	            <th nowrap>股數</th>
	            <th nowrap>價格</th>
	            <th nowrap>時間</th>
	            <th nowrap>刪除</th>
	        </tr>
	    </thead>
	    <tbody>
	    			       
	    </tbody>
	</table>
	
	<p />
	我的 Watch List
	<select id="selectList">
	</select>
	<input type="button" value="Add" onclick="addWatchList()" />
	<p />
	<table id="myWatchTable" class="pure-table pure-table-bordered">
	    <thead>
	        <tr>
	            <th nowrap>id</th>
	            <th nowrap>種類</th>
	            <th nowrap>代號</th>
	            <th nowrap>名稱</th>
	            <th nowrap>警示</th>
	            <!-- 即時盤中資訊  -->
	            <th nowrap>買價</th>
	            <th nowrap>賣價</th>
	            <th nowrap>成交</th>
	            <th nowrap>漲跌</th>
	            <th nowrap>幅%</th>
	            <th nowrap>總量</th>
	            <th nowrap>時間</th>
	            <!-- 買賣交易  -->
	            <th nowrap>買進</th>
	            <th nowrap>賣出</th>
	        </tr>
	    </thead>
	    <tbody>
	    			       
	    </tbody>
	</table>
	
	<!-- Chart 繪圖 begin -->
        <script type = "text/javascript" src = "https://www.gstatic.com/charts/loader.js"></script>
        <script>
            google.charts.load('current', {packages: ['corechart']});
            google.charts.setOnLoadCallback(function() {
                queryHistQuotes('^TWII');
            });
            
            function getYMDHMS(time) {
                var myDate = new Date(time);
                var YMD = addZero(myDate.getFullYear()) + "/" + addZero((myDate.getMonth() + 1)) + "/" + addZero(myDate.getDate());
                var HMS = addZero(myDate.getHours()) + ":" + addZero(myDate.getMinutes()) + ":" + addZero(myDate.getSeconds());
                var YMDHMS = YMD + " " + HMS;
                return YMDHMS;
            }
            
            function getYMD(time) {
                var myDate = new Date(time);
                var YMD = addZero(myDate.getFullYear()) + "/" + addZero((myDate.getMonth() + 1)) + "/" + addZero(myDate.getDate());
                return YMD;
            }
            
            function getMD(time) {
                var myDate = new Date(time);
                var MD = addZero((myDate.getMonth() + 1)) + "/" + addZero(myDate.getDate());
                return MD;
            }
            
            function getHMS(time) {
                var myDate = new Date(time);
                var HMS = addZero(myDate.getHours()) + ":" + addZero(myDate.getMinutes()) + ":" + addZero(myDate.getSeconds());
                return HMS;
            }
            
            function queryHistQuotes(symbol) {
                $.get("/JavaWeb20210816/rest/price/histquotes/" + symbol, function (quotes, status) {
                    console.log("quotes: " + quotes);
                    drawChart(symbol, quotes);
                });
            }
            
            function addZero(n) {
                return (n < 10) ? ("0" + n) : n;
            }
            
            function drawChart(symbol, quotes) {
                // 建立 data 欄位
                var data = new google.visualization.DataTable();
                data.addColumn('string', 'Date');
                data.addColumn('number', 'High');
                data.addColumn('number', 'Open');
                data.addColumn('number', 'Close');
                data.addColumn('number', 'Low');
                data.addColumn('number', 'AdjClose');
                data.addColumn('number', 'Volumn');
                $.each(quotes, function (i, item) {
                    var array = [getMD(quotes[i].date), quotes[i].high, quotes[i].open, quotes[i].close, quotes[i].low, quotes[i].adjClose, quotes[i].volume];
                    data.addRow(array);
                });
                // 設定 chart 參數
                var options = {
                    title: symbol + ' 日K線圖',
                    legend: 'none',
                    vAxes: [
                        {},
                        {minValue: 1, maxValue: 6000000}
                    ],
                    series: {
                        1: {targetAxisIndex: 0, type: 'line', color: '#e7711b'},
                        2: {targetAxisIndex: 1, type: 'bars', color: '#cccccc'}
                    },
                    candlestick: {
                        fallingColor: {strokeWidth: 0, fill: '#0f9d58'}, // green
                        risingColor: {strokeWidth: 0, fill: '#a52714'}   // red
                    },
                    chartArea: {left: 50}
                };
                // 產生 chart 物件
                var chart = new google.visualization.CandlestickChart(document.getElementById('container'));
                // 繪圖
                chart.draw(data, options);
            }
            
        </script>
	
	<div id="container" style="width:90%; height: 400px; margin:10px"></div>
	
	<!-- Chart 繪圖 end -->
	
	<hr />
	
	<ol>
		<li><a href="/JavaWeb20210816/rest/investor/">/JavaWeb20210816/rest/investor/</a></li>
		<li><a href="/JavaWeb20210816/rest/investor/1">/JavaWeb20210816/rest/investor/1</a></li>
		<li><a href="/JavaWeb20210816/rest/stockpool/">/JavaWeb20210816/rest/stockpool/</a></li>
		<li><a href="/JavaWeb20210816/rest/stockpool/1">/JavaWeb20210816/rest/stockpool/1</a></li>
		<li><a href="/JavaWeb20210816/rest/watchlist/">/JavaWeb20210816/rest/watchlist/</a></li>
		<li><a href="/JavaWeb20210816/rest/watchlist/1">/JavaWeb20210816/rest/watchlist/1</a></li>
		<li><a href="/JavaWeb20210816/rest/transactionlog/">/JavaWeb20210816/rest/transactionlog/</a></li>
		<li><a href="/JavaWeb20210816/rest/price/histquotes/2330.tw">/JavaWeb20210816/rest/price/histquotes/2330.tw</a></li>
		<li><a href="/JavaWeb20210816/rest/price/histquotes/^TWII">/JavaWeb20210816/rest/price/histquotes/^TWII</a></li>
		
	</ol>
	
</body>
</html>