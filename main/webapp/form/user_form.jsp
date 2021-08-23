<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="myel" uri="/tlds/mytld" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet"
		href="https://unpkg.com/purecss@2.0.6/build/pure-min.css">
	<meta charset="UTF-8">
	<title>User Form</title>
	<script>
		function createAndUpdateConfirm() {
			var username = document.getElementById('u_username').value;
			var password = document.getElementById('u_password').value;
			if(username == '') {
				alert('請輸入使用者名稱?')
				return false;
			}
			if(password == '') {
				alert('請輸入使用者密碼?')
				return false;
			}
			return true;
		}
	
		function delete_confirm(u_id) {
			var yes = confirm('是否要刪除 u_id = ' + u_id + ' 這筆資料?');
			if(yes) {
				window.location.href='/JavaWeb20210816/lab/user/delete?u_id=' + u_id;
			}
		}
	</script>
	
</head>
<body style="padding: 15px">
	<table>
		<tr>
			<td valign="top" style="padding: 10px">
				<form id="user_form" class="pure-form" 
				      method="post"
				      onsubmit="return createAndUpdateConfirm()" 
				      action="/JavaWeb20210816/lab/user/update">
					<fieldset>
						<legend>
							<img src="/JavaWeb20210816/image/man.png" width="40">&nbsp;&nbsp;&nbsp;&nbsp;User
							form
						</legend>
						序號: <input type="number" id="u_id" name="u_id" readonly value="${ user.u_id }" />
						<p />
						名稱: <input type="text" placeholder="請輸入帳號" id="u_username" name="u_username" value="${ user.u_username }" />
						<p />
						密碼: <input type="text" placeholder="請輸入密碼" id="u_password" name="u_password" value="${ myel:decode(user.u_password) }" />
						<p />
						權限: <select id="u_priority" name="u_priority">
							<option value="0" ${ user.u_priority == 0 ? 'selected' : '' } >一般</option>
							<option value="1" ${ user.u_priority == 1 ? 'selected' : '' }>管理</option>
						</select>
						<p />
						<button type="submit" class="pure-button pure-button-primary">${ user == null ? '新增' : '修改' }</button>
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
							<th>update</th>
							<th>delete</th>
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
								<td>${ myel:decode(user.u_password) }</td>
								<td>${ user.u_createtime }</td>
								<td>
									<button type="button"
											onclick="window.location.href='/JavaWeb20210816/lab/user/get?u_id=${ user.u_id }';" 
											class="pure-button pure-button-primary">
										Update
									</button>
								</td>
								<td>
									<button type="button"
											onclick="delete_confirm(${ user.u_id })"
											class="pure-button pure-button-primary">
										Delete
									</button>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
			</td>
		</tr>
	</table>




</body>
</html>