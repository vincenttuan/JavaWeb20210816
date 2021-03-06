<%@ page language="java" contentType="text/html; charset=UTF-8"
	session="false" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Session form</title>
</head>
<body style="padding: 15px;">

	<form method="post" class="pure-form" action="/JavaWeb20210816/controller/session">
		<fieldset>
			<legend>Session form (記帳輸入) - 服務數量: ${ applicationScope['count'] }</legend>
			<input type="number" placeholder="請輸入金額" name="amount" /> 
			<p />
			<button type="submit" class="pure-button pure-button-primary">
				submit
			</button>
			<button type="button"
					onclick="window.location.href='/JavaWeb20210816/controller/session_clear';" 
					class="pure-button pure-button-primary">
				clear
			</button>
		</fieldset>
		<p />
		<fieldset>
			<legend>Session result (記帳紀錄)</legend>
			<!-- 
			Session id : ${ pageContext.session.id } <p />
			${ sessionScope['amount_list'] }
			-->
			Session id : ${ session_id } <p />
			${ session_amount_list }
			<p />
		</fieldset>
	</form>

</body>
</html>