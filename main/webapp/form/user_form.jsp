<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
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
			<td valign="top" style="padding: 10px">
				<form class="pure-form">
					<fieldset>
						<legend>
							<img src="/JavaWeb20210816/image/man.png" width="40">&nbsp;&nbsp;&nbsp;&nbsp;User
							form
						</legend>
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
			<td valign="top" style="padding: 10px">
				<form class="pure-form" method="post"
					action="/JavaWeb20210816/lab/user/query">
					<fieldset>
						<legend>
							<img src="/JavaWeb20210816/image/team.png" width="40">&nbsp;&nbsp;&nbsp;&nbsp;User
							list
						</legend>
						<button type="submit" class="pure-button pure-button-primary"
							style="float: right; margin-left: 5px">查詢</button>
						<input type="text" name="u_username_keyword"
							placeholder="請輸入名字關鍵字"
							style="float: right; background-image: url('/JavaWeb20210816/image/search.png'); background-repeat: no-repeat; background-position: right;">
					</fieldset>
				</form>
				<p />
				<table class="pure-table pure-table-bordered">
					<thead>
						<tr>
							<th>id</th>
							<th>image</th>
							<th>priority</th>
							<th>usernmae</th>
							<th>password(encode)</th>
							<th>password(decode)</th>
							<th>createtime</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${ users }">
							<tr>
								<td>${ user.u_id }</td>
								<td><img
									src="/JavaWeb20210816/image/${ user.u_priority==0?'man':'programmer' }.png"
									width="30"></td>
								<td>${ user.u_priority }</td>
								<td>${ user.u_username }</td>
								<td>${ user.u_password }</td>
								<td></td>
								<td>${ user.u_createtime }</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</td>
		</tr>
	</table>




</body>
</html>