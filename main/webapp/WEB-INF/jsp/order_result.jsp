<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Order Result</title>
</head>
<body style="padding: 15px;">

	<form class="pure-form">
		<fieldset>
			<legend>Order Result</legend>
			商品名稱 : ${ p_name }
			<p />
			付款方式 : ${ p_payNames }
			<p />
			消費金額 : ${ total }
			
			<hr />
			
			商品價格 : ${ p_price }
			<p />
			商品數量 : ${ p_amount }
			<p />
			商品折扣 : ${ p_discount }
			<p />
			備註說明 : ${ p_memo }
			
			<hr />
			
			<button 
				type="button" 
				class="pure-button pure-button-primary"
				onclick="window.history.back()">
				Back
			</button>
		</fieldset>
	</form>

</body>
</html>