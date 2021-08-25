<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<title>Food Form</title>
</head>
<body style="padding: 15px">
	<form class="pure-form" method="post"
		action="/JavaWeb20210816/lab/food/submit">
		<fieldset>
			<legend>Food Form</legend>
			選擇商品:
			<select name="food_id">
				<c:forEach var="food" items="${ foods }">
					<option value="${ food.id }">
						${ food.name } 剩餘: ${ food.amount }
					</option>
				</c:forEach>
			</select>
			<p />
			購買數量:
			<input name="food_qty" type="number" placeholder="請輸入購買數量" value="0" />
			<p />
			<!-- 
			${ foods }
			-->
			<p />
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

			<button type="submit" class="pure-button pure-button-primary">
				Submit</button>
			<button type="reset" class="pure-button pure-button-primary">
				Reset</button>
			<button type="button"
					onclick="window.location.href='/JavaWeb20210816/lab/food/chart'" 
					class="pure-button pure-button-primary">
				Chart</button>	
		</fieldset>
	</form>
</body>
</html>