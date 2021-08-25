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
		$(document).ready(function() {
			
			function getInvestorData(id) {
				var url = '/JavaWeb20210816/rest/investor/' + id;
				$.get(url, function(datas, status) { // datas : 回傳的 json 資料, status : 連線狀態
					console.log(status);
					console.log(datas);
				});
			}
			
			getInvestorData(1);
		});
	</script>
</head>
<body>
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