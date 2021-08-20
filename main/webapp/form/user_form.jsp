<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
<meta charset="UTF-8">
<title>User Form</title>
</head>
<body style="padding: 15px">
	<table>
		<tr>
			<td valign="top">
				<form class="pure-form">
					<fieldset>
						<legend>User form</legend>
						序號: <input type="number" placeholder="id" />
						<p />
						名稱: <input type="text" placeholder="username" />
						<p />
						密碼: <input type="password" placeholder="password" />
						<p />
						權限: <select name="u_priority">
							<option value="0">一般</option>
							<option value="1">管理</option>
						</select>
						<p />
						狀態: <input type="radio" value="1" name="status">新增 <input
							type="radio" value="2" name="status">修改
						<p />
						<button type="submit" class="pure-button pure-button-primary">新增</button>
						<button type="submit" class="pure-button pure-button-primary">修改</button>
						<p />
					</fieldset>
				</form>
			</td>
			<td valign="top">
				<form class="pure-form">
					<fieldset>
						<legend>
							User list 
							<button type="button" class="pure-button pure-button-primary" style="float: right">查詢</button>
						</legend>
						<table class="pure-table pure-table-bordered">
							<thead>
								<tr>
									<th>id</th>
									<th>usernmae</th>
									<th>password(encode)</th>
									<th>password(decode)</th>
									<th>priority</th>
									<th>createtime</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>Honda</td>
									<td>MTIzNA==</td>
									<td>1234</td>
									<td>0</td>
									<td>2021/08/20</td>
								</tr>
								<tr>
									<td>2</td>
									<td>Mary</td>
									<td>NTY3OA==</td>
									<td>5678</td>
									<td>1</td>
									<td>2021/08/20</td>
								</tr>
							</tbody>
						</table>
					</fieldset>
				</form>
			</td>
		</tr>
	</table>




</body>
</html>