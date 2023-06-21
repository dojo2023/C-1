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
</head>
<body>

	<span class="title">Schedule registration</span>

	<form method="GET" action="/KSHMY/CalendarRegistServlet">

		<br>
		営業所：
		<select id="branch" name="branch">
		<c:forEach var="e" items="${branch}">
			<option value="${e}">${e}</option>
		</c:forEach>

		</select>

		<button id="add" type="button" onclick="workspaceAdd()">+</button>
		<div id="new">
			<input type="text" name="workspace" value="" placeholder="営業所">
		</div>

		<br>
		<label for="date">開始日時：</label>
		<input type="datetime-local"
			id="date" name="start_date" value="" />
			 <br>
		<label for="date">終了日時：</label>
		<input type="datetime-local" id="date" name="end_date" value="" />
		<br>

		色：<label><input type="radio" name="color"
			value="e49aab" checked>赤</label>
			<label><input type="radio" name="color"
			value="9ae3ae">緑</label> <label>
			<input type="radio" name="color"
			value="9ad0e3">青</label>
			<br>

		メモ：
		<textarea name="memo"></textarea>
		<br>

		<input type="submit" name="SUBMIT" value="登録">

	</form>
</body>
<script src='/KSHMY/js/calendar_regist.js'></script>
</html>