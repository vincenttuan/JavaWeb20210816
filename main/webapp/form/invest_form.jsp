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
    	var investorid = 1;
    
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
		
	    function buySell(bs, stockpoolid) {
	    	console.log("investorid: " + investorid + ", bs: " + bs + ", stockpoolid: " + stockpoolid);
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
	    	
	    }
	    
	    // JQuery 程式進入點
		$(document).ready(function() {
			
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
						var html = '<tr><td>{0}</td><td>{1}</td><td>{2}</td><td nowrap>{3}</td><td>{4}</td><td>{5}</td><td nowrap>{6}</td></tr>';
						$('#myTransTable').append(
							String.format(html, item.id, item.bs, item.stockPool.symbol, item.stockPool.symbolname, item.amount, item.price, item.tdate)		
						);
					});
					//-- 我的 Watch List ----------------------------
					$('#myWatchTable tbody > tr').remove(); // 先將畫面暫存資料清除
					$.each(datas.watchLists, function(i, item) { 
						var html = '<tr><td>{0}</td><td>{1}</td><td>{2}</td><td nowrap>{3}</td><td>{4}</td><td style="color:{12}" align="right">{5}</td><td style="color:{12}" align="right">{6}</td><td style="color:{12}" align="right">{7}</td><td style="color:{12}" align="right">{8}</td><td style="color:{12}" align="right">{9}</td><td align="right">{10}</td><td nowrap>{11}</td><td nowrap>{13}</td><td nowrap>{14}</td></tr>';
						$('#myWatchTable').append(
							String.format(html, item.id, item.stockPool.typeid, item.stockPool.symbol, item.stockPool.symbolname, item.stockPool.warning, 
									            item.realTimeStock.bid, item.realTimeStock.ask, item.realTimeStock.lastprice, item.realTimeStock.change, item.realTimeStock.changePercent, numberFormat(item.realTimeStock.volume), item.realTimeStock.transdate, (item.realTimeStock.change >= 0)?'red':'#005100',
									            '<input type="button" value="買" onclick="buySell(1, ' + item.stockPool.id + ')" />', '<input type="button" value="賣" onclick="buySell(2, ' + item.stockPool.id + ')" />')		
						);
					});
					
				});
			}
			
			getInvestorData();
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
	        </tr>
	    </thead>
	    <tbody>
	    			       
	    </tbody>
	</table>
	
	<p />
	我的 Watch List
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
	
	<hr />
	<ol>
		<li><a href="/JavaWeb20210816/rest/investor/">/JavaWeb20210816/rest/investor/</a></li>
		<li><a href="/JavaWeb20210816/rest/investor/1">/JavaWeb20210816/rest/investor/1</a></li>
		<li><a href="/JavaWeb20210816/rest/stockpool/">/JavaWeb20210816/rest/stockpool/</a></li>
		<li><a href="/JavaWeb20210816/rest/stockpool/1">/JavaWeb20210816/rest/stockpool/1</a></li>
		<li><a href="/JavaWeb20210816/rest/watchlist/">/JavaWeb20210816/rest/watchlist/</a></li>
		<li><a href="/JavaWeb20210816/rest/watchlist/1">/JavaWeb20210816/rest/watchlist/1</a></li>
		<li><a href="/JavaWeb20210816/rest/transactionlog/">/JavaWeb20210816/rest/transactionlog/</a></li>
		<li><a href="/JavaWeb20210816/rest/transactionlog/1">/JavaWeb20210816/rest/transactionlog/1</a></li>
		
	</ol>
	
</body>
</html>