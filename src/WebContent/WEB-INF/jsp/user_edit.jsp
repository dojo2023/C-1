<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ page import = "model.Users" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ編集画面</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
<link rel = "stylesheet" href = "/KSHMY/css/user_edit.css">
</head>
<body>
	<h1><a href="/KSHMY/MainServlet"><img src="/KSHMY/img/KMlogo.jpeg" width="150" height="100" alt="KM"></a></h1>
	<a href="/KSHMY/MainServlet">＜メインへ戻る</a>
	<span class="title">User information edition</span>
	<p>項目はすべて入力してください</p>


	<form id="edit-form"method="POST" action="/KSHMY/UserEditServlet">
	<table>
	<tr><td><input type="text" name="name" value="${card.name}" placeholder="氏名"></td></tr>

		<tr><td>所属地
		<select id="select_workspace" name="workspace">
			<c:forEach var="e" items="${workspace}" >
				<option value="${e}">${e}</option>
			</c:forEach>
			<option id="new_select" value="新規">新規</option>
	    </select><button id="add" type="button" onclick="workspaceAdd()">+</button></td>

	    <td>都道府県
	    	<select id="prefecture_number" name="prefecture_number">
			<option value=1>東京都</option><option value=2>神奈川県</option><option value=3>埼玉県</option><option value=4>千葉県</option><option value=5>栃木県</option>
			<option value=6>群馬県</option><option value=7>茨城県</option>
			</select></td>
	    </tr>

	    <tr><td id = "new"><input type="text" name="workspace" value="" placeholder="所属地"></td></tr>

	<tr><td><input type="text" name="user_id" value="${card.user_id}" placeholder="ID" readonly></td><td><input type="password" name="user_pw" value="${card.user_pw}" placeholder="パスワード" readonly></td></tr>
		</table>
		<table>
		<tr><td>好きなジャンル</td></tr>
			<tr><td colspan="2">第1位<select name="first">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option>
				<option value="その他">その他</option></td>
			<td colspan="2">第2位<select name="second">
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
		<input class="normal edit" id="save" name="save" type="submit" value="保存">
	</form>

	<input type="hidden" id="cw" value="${card.workspace}">
	<input type="hidden" id="cp" value="${card.prefecture_number}">
	<input type="hidden" id="cf" value="${card.first}">
	<input type="hidden" id="cs" value="${card.second}">
	<input type="hidden" id="ct" value="${card.third}">

</body>
<script src='/KSHMY/js/user_edit.js'></script>
</html>