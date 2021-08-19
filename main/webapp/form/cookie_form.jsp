<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Cookie form</title>
</head>
<body style="padding: 15px;">

	<form method="post" class="pure-form" action="/JavaWeb20210816/controller/cookie">
		<fieldset>
			<legend>Cookie form (記帳輸入)</legend>
			<input type="number" placeholder="請輸入金額" name="amount" /> 
			<p />
			<button type="submit" class="pure-button pure-button-primary">
				submit
			</button>
			<button type="button"
					onclick="window.location.href='/JavaWeb20210816/form/cookie_result.jsp';" 
					class="pure-button pure-button-primary">
				view
			</button>
		</fieldset>
		<p />
		<fieldset>
			<legend>Cookie result (記帳紀錄)</legend>
			${ cookie['amount'].value }
			<p />
		</fieldset>
	</form>

</body>
</html>