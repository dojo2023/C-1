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
	<span class="title">Schedule editing</span>

	<form  id=editform method="GET"  action="/KSHMY/CalendarEditServlet">


			<br>
			営業所：<select id="workspace" name="workspace">
			<c:forEach var="e" items="${branch}" >
				<option value="${e}">${e}</option>
	        </c:forEach>
	    </select><button id="add" type="button" onclick="workspaceAdd()">+</button>
		<div id = "new"><input type="text" name="workspace" value="" placeholder="営業所">
		</div>
			<br>
			開始日時：<input type="text" name="start_date" value="${Calendar.start_date}"><br>
			終了日時：<input type="text" name="end_date" value="${Calendar.end_date}"><br>

			色：<label><input type="radio" name="lang" value="color1">青</label>
			<label><input type="radio" name="lang" value="color2">緑</label>
			<label><input type="radio" name="lang" value="color3">赤</label><br>

			 メモ：<input type="text"  name="memo" value="${Calendar.memo}"><br>

				<input class="normal" type="submit" name="SUBMIT" value="更新">
				<input class="reversal" type="submit" name="SUBMIT" value="削除">



	</form>
</body>
<script src='/KSHMY/js/calendar_edit.js'></script>
</html>