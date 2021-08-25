<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<title>Food Result</title>
</head>
<body style="padding: 15px">
	<form class="pure-form">
		<fieldset>
			<legend>Food Result</legend>
			購買商品: ${ food.name } <p />
			購買數量: ${ qty } <p />
			商品價格: ${ food.price } <p />
			剩餘數量: ${ food.amount } <p />
			購買金額: ${ total } <p />
			庫存數量:
			<table class="pure-table pure-table-bordered">
				<thead>
					<tr>
						<th>id</th>
						<th>Name</th>
						<th>Price</th>
						<th>Amount</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="food" items="${ foods }" >
					<tr>
						<td>${ food.id }</td>
						<td>${ food.name }</td>
						<td>${ food.price }</td>
						<td>${ food.amount }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
			<p />
			<button type="button" 
					onclick="window.location.href='/JavaWeb20210816/lab/food/form';"
					class="pure-button pure-button-primary">
				繼續購物
			</button>
			
		</fieldset>
	</form>
</body>
</html>