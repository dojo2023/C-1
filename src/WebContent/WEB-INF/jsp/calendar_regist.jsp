<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Calendar"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー登録</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
<link rel="stylesheet" href="/KSHMY/css/calendar.css">
<link rel = "stylesheet" href = "/KSHMY/css/calendar_regist.css">
</head>
<body>

	<header>
		<nav class="haikei">
		<ul class="gnav_wrap">
		<li class="main_menu">
			<a href ="/KSHMY/MainServlet" ><img src = "/KSHMY/img/KMlogo.jpeg" width="150" height="100" alt="KSHMY"></a>
		</li>
		<li class="main_menu">
			 <a href="/KSHMY/MainServlet">メイン</a>
		</li>
		<li class="main_menu">
			<a href="/KSHMY/CalendarServlet">カレンダー</a>
		</li>
		<li class="main_menu">
			 グルメ
			<ul class="sub_menu">
				<a href="/KSHMY/GourmetServlet"><li>一覧/検索</li></a>
				<a href="/KSHMY/GourmetRegistServlet"><li>登録</li></a>
			</ul>
		</li>
			<li class="main_menu"><a href="/KSHMY/LogoutServlet">ログアウト</a></li>
			<li class="main_menu"><a href ="/KSHMY/UserEditServlet" >ユーザー</a></li>
		</ul>
		</nav>
	</header>
		<div class = "conteinar">
			<hr size="3" color="#404040">
		</div>

	<div id=waku>
		<div id=title1>
			<span class="title">Schedule registration</span>
		</div>

	<!-- jspでクライアントが入力した情報をregistservletにpostする -->
		<form name = "click" id=editform method="POST" action="/KSHMY/CalendarRegistServlet">

		<br>
			<br> 営業所：
			<select id="branch" name="branch">
				<c:forEach var="e" items="${branch}">
					<option value="${e}">${e}</option>
				</c:forEach>
			</select>
				<button id="add" type="button" onclick="workspaceAdd()">+</button><br>
				<div id="text-box">
					<input id="new" type="text" name="none" value="" placeholder="営業所">
				</div>

			<table>
				<tr>
					<td>
						<label for="date">開始日時：</label>
						<input type="datetime-local" id="date" name="start_date" value="${date}" />
					</td>
					<td>
						<label for="date">終了日時：</label>
						<input type="datetime-local" id="date" name="end_date" value="${date}" />
					</td>
				</tr>
			</table>
			 			色：
						<input type="radio" name="color" id="colorimage1" value="e49aab" checked><label for="colorimage1"></label>
						<input type="radio" name="color" id="colorimage2" value="9ae3ae"><label for="colorimage2"></label>
						<input type="radio" name="color" id="colorimage3" value="9ad0e3"><label for="colorimage3"></label>
						<br>
							メモ：
								<textarea class="textarean"  name="memo"></textarea>
						<br>
							<input name ="btn" class="normal" type="submit" name="SUBMIT" value="登録" >

		</form>
	</div>
</body>
			<br>
			<br>
			<hr>
			<div id="footer">
				<p>&copy;Copyright KSHMY. All rights reserved.</p>
			</div>

	<script src='/KSHMY/js/calendar_regist.js'></script>
</html>