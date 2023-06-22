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

	<form  id=editform method="POST"  action="/KSHMY/CalendarEditServlet">


			<br>
			営業所：<select id="branch" name="none">
			<c:forEach var="e" items="${branch}" >
				<option value="${e}">${e}</option>
	        </c:forEach>
	    </select>
	    <button id="add" type="button" onclick="workspaceAdd()">+</button>
		<div id = "new"><input type="text" name="branch" value="" placeholder="営業所">
		</div>

			<br>
			<label for="date">開始日時：</label>
			<input type="datetime-local"  id="date" name="start_date" value="${calendar.start_date}" />
			<br>
			<label for="date">終了日時：</label>
			<input type="datetime-local"  id="date" name="end_date" value="${calendar.end_date}" />
			<br>
			色：<label><input type="radio" name="color" value="e49aab" > 赤</label>
			<label><input type="radio" name="color" value="9ae3ae"> 緑</label>
			<label><input type="radio" name="color" value="9ad0e3"> 青</label><br>

			メモ：<textarea name = "memo">${calendar.memo}</textarea><br>

				<input class="normal" type="submit" name="SUBMIT" value="更新">
				<input class="reversal" type="submit" name="SUBMIT" value="削除">


	</form>
		<input type="hidden"  id = "branch_box"  value="${calendar.branch}">
		<input type="hidden"  id = "color_box"  value="${calendar.color}">

</body>
<script src='/KSHMY/js/calendar_edit.js'></script>
</html>