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
	<h1><a href="/KSHMY/MainServlet"><img src="/KSHMY/img/KMlogo.jpeg" width="100" height="100" alt="KM"></a></h1>


<div class = "conteinar">
<hr size="3" color="#404040">
	<div class="title-box" id="title-box">
		<span class="title" id="uie">User information edition</span>
	</div>

	<div class="item">
		<a href="/KSHMY/MainServlet">＜メインへ戻る</a>
		<div class="attention">項目はすべて入力してください</div>
	</div>

	<form id="edit-form"method="POST" action="/KSHMY/UserEditServlet">
	<table id="table">

	<tr><td colspan="3"><input type="text" name="name" value="${card.name}" placeholder="氏名" required></td></tr>

		<tr><td colspan="3">所属地:
		<select id="select_workspace" name="workspace">
			<c:forEach var="e" items="${workspace}" >
				<option value="${e}">${e}</option>
			</c:forEach>
			<option id="new_select" value="新規">新規</option>
	    </select><button id="add" type="button" onclick="workspaceAdd()">+</button></td>

	    <td colspan="3">所属地の都道府県:
	    	<select id="prefecture_number" name="prefecture_number">
			<option value=1>東京都</option><option value=2>神奈川県</option><option value=3>埼玉県</option><option value=4>千葉県</option><option value=5>栃木県</option>
			<option value=6>群馬県</option><option value=7>茨城県</option>
			</select></td>
	    </tr>

	    <tr><td colspan="3"><input id = "new" type="text" name="none" value="" placeholder="所属地" ></td></tr>

	<tr><td colspan="3">ID: <input type="text" name="user_id" value="${card.user_id}" placeholder="ID" readonly></td><td>パスワード: <input type="password" name="user_pw" value="${card.user_pw}" placeholder="パスワード" readonly></td></tr>
		</table>
		<table id="genretable">
		<tr><td>好きなジャンル</td></tr>
			<tr><td colspan="2">第1位:<select id = "first" name="first">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option>
				<option value="その他">その他</option></td>
			</select>
			<td colspan="2">第2位:<select id = "second" name="second">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option>
				<option value="その他">その他</option></td>
			</select>
			<td colspan="2">第3位:<select id = "third" name="third">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option>
				<option value="その他">その他</option></td></tr>
			</select>
	</table>
	<div class="error-box">
		<span id="error_message"></span>
	</div>
		<input class="normal edit" id="save" name="save" type="submit" value="保存">
	</form>


</div>


 <div id="footer">
 <hr>
    <p>&copy;Copyright KSHMY. All rights reserved.</p>
 </div>

	<input type="hidden" id="cw" value="${card.workspace}">
	<input type="hidden" id="cp" value="${card.prefecture_number}">
	<input type="hidden" id="cf" value="${card.first}">
	<input type="hidden" id="cs" value="${card.second}">
	<input type="hidden" id="ct" value="${card.third}">


</body>
<script src='/KSHMY/js/user_edit.js'></script>
</html>