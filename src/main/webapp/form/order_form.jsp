<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>Order Form</title>
</head>
<body style="padding: 15px;">

	<form method="post" class="pure-form" action="/JavaWeb20210816/controller/order">
		<fieldset>
			<legend>Order Form</legend>
			
			商品選擇 : 
			<select name="p_id">
				<option value="0">Water</option>
				<option value="1">Coffee</option>
				<option value="2">Milk</option>
				<option value="3">Tea</option>
			</select>
			<p />
			商品價格 :
			<input name="p_price" type="number" placeholder="請輸入價格" />
			<p />
			商品數量 :
			<input name="p_amount" type="number" placeholder="請輸入數量" />
			<p />
			付款方式 : <input name="p_pay" type="checkbox" value="0"> 現金 
			        <input name="p_pay" type="checkbox" value="1"> 信用卡
			<p />
			折扣選擇 : <input name="p_discount" type="radio" value="0.9"> 9折
					<input name="p_discount" type="radio" value="0.85"> 85折
					<input name="p_discount" type="radio" value="0.7"> 7折
			<p />
			備註說明 :<br />
			<textarea name="p_memo" rows="5" cols="32"></textarea>
			<p />
				
			<button 
				type="submit" 
				class="pure-button pure-button-primary">
				Submit
			</button>
			
			<button 
				type="reset" 
				class="pure-button pure-button-primary">
				Reset
			</button>
		</fieldset>
	</form>

</body>
</html>