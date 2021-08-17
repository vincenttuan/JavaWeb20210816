<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>BMI 表單輸入</title>
</head>
<body style="padding: 15px;">

	<form method="post" class="pure-form" action="/JavaWeb20210816/controller/calc">
		<fieldset>
			<legend>BMI 表單輸入</legend>
			<input type="number" placeholder="請輸入身高" name="h" /> 
			<p />
			<input type="number" placeholder="請輸入體重" name="w" /> 
			<p />
			<button type="submit" class="pure-button pure-button-primary">
				計算
			</button>
			<button type="reset" class="pure-button pure-button-primary">
				重設
			</button>
		</fieldset>
	</form>

</body>
</html>