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
		
	    // JQuery 程式進入點
		$(document).ready(function() {
			
			function getInvestorData(id) {
				var url = '/JavaWeb20210816/rest/investor/' + id;
				$.get(url, function(datas, status) { // datas : 回傳的 json 資料, status : 連線狀態
					console.log(status);
					console.log(datas);
					//-- 歡迎訊息 ------------------------------------
					$('#username').text(datas.username);
					$('#email').text(datas.email);
					//-- 我的交易紀錄 ---------------------------------
					$('#myTransTable tbody > tr').remove(); // 先將畫面暫存資料清除
					$.each(datas.transactionLogs, function(i, item) { 
						var html = '<tr><td>{0}</td><td>{1}</td><td>{2}</td><td>{3}</td><td>{4}</td><td>{5}</td><td>{6}</td></tr>';
						$('#myTransTable').append(
							String.format(html, item.id, item.bs, item.stockPool.symbol, item.stockPool.symbolname, item.amount, item.price, item.tdate)		
						);
					});
					//-- 我的 Watch List ----------------------------
					$('#myWatchTable tbody > tr').remove(); // 先將畫面暫存資料清除
					$.each(datas.watchLists, function(i, item) { 
						var html = '<tr><td>{0}</td><td>{1}</td><td>{2}</td><td>{3}</td><td>{4}</td><td style="color:{12}">{5}</td><td style="color:{12}">{6}</td><td style="color:{12}">{7}</td><td style="color:{12}">{8}</td><td style="color:{12}">{9}</td><td>{10}</td><td>{11}</td></tr>';
						$('#myWatchTable').append(
							String.format(html, item.id, item.stockPool.typeid, item.stockPool.symbol, item.stockPool.symbolname, item.stockPool.warning, 
									            item.realTimeStock.bid, item.realTimeStock.ask, item.realTimeStock.lastprice, item.realTimeStock.change, item.realTimeStock.changePercent, item.realTimeStock.volume, item.realTimeStock.transdate, (item.realTimeStock.change >= 0)?'red':'#005100')		
						);
					});
					
				});
			}
			
			getInvestorData(1);
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
	            <th>id</th>
	            <th>買賣</th>
	            <th>商品代號</th>
	            <th>商品名稱</th>
	            <th>股數</th>
	            <th>價格</th>
	            <th>交易日</th>
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
	            <th>id</th>
	            <th>種類</th>
	            <th>商品代號</th>
	            <th>商品名稱</th>
	            <th>警示股</th>
	            <!-- 即時盤中資訊  -->
	            <th>買價</th>
	            <th>賣價</th>
	            <th>成交價</th>
	            <th>漲跌</th>
	            <th>漲跌幅%</th>
	            <th>交易量</th>
	            <th>交易時間</th>
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