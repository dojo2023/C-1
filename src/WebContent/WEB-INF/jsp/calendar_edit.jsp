<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.Calendar" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー編集</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
<link rel = "stylesheet" href = "/KSHMY/css/calendar_edit.css">
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
			<div class ="img">
		<li class="main_menu"><a href ="/KSHMY/UserEditServlet" ><img src = "/KSHMY/img/user.png" alt="ユーザー"></a></li>
    	</div>
		</ul>
		</nav>
			<hr size="3" color="#404040">
	</header>

	<div id=waku>
		<div id=title1>
			<span class="title">Schedule editing</span>
		</div>

	<form  id=editform method="POST"  action="/KSHMY/CalendarEditServlet">

		<br>
			営業所：
			<select id="branch" name="branch">
				<c:forEach var="e" items="${branch}" >
					<option value="${e}">${e}</option>
	        	</c:forEach>
	    	</select>
				<button id="add" type="button" onclick="workspaceAdd()">+</button><br>
				<div>
					<input type="text" id = "new" name="none" value="" placeholder="営業所">
				</div>

			<table>
				<tr>
					<td>
						<label for="date">開始日時：</label>
						<input type="datetime-local"  id="date" name="start_date" value="${calendar.start_date}" />
					</td>
					<td>
						<label for="date">終了日時：</label>
						<input type="datetime-local"  id="date" name="end_date" value="${calendar.end_date}" />
					</td>
				</tr>
			</table>
						色：
						<input type="radio" name="color" value="e49aab"  id="colorimage1"><label for="colorimage1"></label>
						<input type="radio" name="color" value="9ae3ae" id="colorimage2"><label for="colorimage2"></label>
						<input type="radio" name="color" value="9ad0e3" id="colorimage3"><label for="colorimage3"></label>
					<br>
						メモ：
						<textarea class="textarean" name = "memo">${calendar.memo}</textarea>
					<br>
			<table id=tyuuou>
				<tr>
					<td>
						<input class="normal" type="submit" onclick="return confirmTest()"  name="SUBMIT" value="更新">
					</td>
					<td>
						<input class="reversal" type="submit"  onclick="return confirmTest2()" name="SUBMIT" value="削除">
					</td>
				</tr>
			</table>

						<input type="hidden" name ="number" value="${calendar.number}">

			</form>
						<input type="hidden"  id = "branch_box"  value="${calendar.branch}">
						<input type="hidden"  id = "color_box"  value="${calendar.color}">

	</div>
</body>
			<br>
			<br>
			<hr>
			<div id="footer">
				 <p>&copy;Copyright KSHMY. All rights reserved.</p>
			</div>

	<script src='/KSHMY/js/calendar_edit.js'></script>
</html>