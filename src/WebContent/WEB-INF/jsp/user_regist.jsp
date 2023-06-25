<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録画面</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
<link rel = "stylesheet" href = "/KSHMY/css/user_regist.css">
</head>
<body>
	<h1><img src="/KSHMY/img/KMlogo.jpeg" width="100" height="100" alt="KM"></h1>

<div class = "conteinar">
<hr size="3" color="#404040">
	<div class="title-box">
		<span class="title">User registration</span>
	</div>

	<div class="item">
		<a href="/KSHMY/LoginServlet">＜戻る</a>
		<div class="attention">項目はすべて入力してください</div>
	</div>

	<form id="regist-form" method="POST" action="/KSHMY/UserRegistServlet">
	<table id="table">

	<tr><td colspan="3"><input type="text" name="name" value="" placeholder="氏名" required></td></tr>
		<tr><td colspan="3">所属地
		<select id="select_workspace" name="workspace">
			<c:forEach var="e" items="${workspace}" >
				<option value="${e}">${e}</option>
	        </c:forEach>
	    </select><button id="add" type="button" onclick="workspaceAdd()">+</button></td>
	    <td colspan="3">所属地の都道府県
	    	<select name="prefecture_number">
			<option value=1>東京都</option><option value=2>神奈川県</option><option value=3>埼玉県</option><option value=4>千葉県</option><option value=5>栃木県</option>
			<option value=6>群馬県</option><option value=7>茨城県</option>
			</select></td>
	    </tr>
	    <tr><td colspan="3"><input id = "new" type="text" name="none" value="" placeholder="所属地" ></td></tr>
	<tr><td colspan="3"><input type="text" name="user_id" value="" placeholder="ID" required></td><td><input type="text" name="user_pw" value="" placeholder="パスワード" required></td></tr>
		</table>
		<table id="genretable">
		<tr><td colspan="2">好きなジャンル</td></tr>
			<tr><td colspan="2">第1位<select name="first">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option>
				<option value="その他">その他</option></td>
			<td colspan="2">第2位<select name="secound">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option>
				<option value="その他">その他</option></td>
			<td colspan="2">第3位<select name="third">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option>
				<option value="その他">その他</option></td></tr>
	</table>
	<div class="error-box">
		<span id="error_message"></span>
	</div>
    	<input class="normal regist" id="regist" name="regist" type="submit" value="登録">
    </form>
    </div>


 <div id="footer">
 <hr>
    <p>&copy;Copyright KSHMY. All rights reserved.</p>
 </div>

</body>
<script src='/KSHMY/js/user_regist.js'></script>
</html>