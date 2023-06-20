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
		<select id="workspace" name="workspace">
			<c:forEach var="e" items="${card.workspace}" >
			<option value="${e}">${e}</option>
			</c:forEach>
	    </select><button id="add" type="button" onclick="workspaceAdd()">+</button></td>

	    <td>都道府県
	    	<select id="prefecture_number" name="prefecture_number">
	    	<c:forEach var="e" items="${prefecture_number}" >
			<option value="${e}">${e}</option>
			</c:forEach>
			</select></td>
	    </tr>

	    <tr><td id = "new"><input type="text" name="workspace" value="${card.workspace}" placeholder="所属地"></td></tr>

	<tr><td><input type="text" name="user_id" value="${card.user_id}" placeholder="ID" readonly></td>

		<td><input type="password" name="user_pw" value="${card.user_pw}" placeholder="パスワード" readonly></td></tr>

		<tr><td>好きなジャンル</td></tr>
			<tr><td>第1位<select name="first">
				<c:forEach var="e" items="${card.first}" >
				<option value="${e}">${e}</option>
				</c:forEach>
			</select></td>
			<td>第2位<select name="second">
				<c:forEach var="e" items="${card.second}" >
				<option value="${e}">${e}</option>
				</c:forEach>
			</select></td>
			<td>第3位<select name="third">
				<c:forEach var="e" items="${card.third}" >
				<option value="${e}">${e}</option>
				</c:forEach>
			</select></td></tr>
	</table>
		<input class="normal edit" id="save" name="save" type="submit" value="保存">
	</form>

</body>
<script src='/KSHMY/js/user_edit.js'></script>
</html>