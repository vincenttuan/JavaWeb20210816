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
	            <th>bs</th>
	            <th>symbol</th>
	            <th>symbolname</th>
	            <th>amount</th>
	            <th>price</th>
	            <th>tdate</th>
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