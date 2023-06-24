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
	<div id=waku>

	<div id=title1>
	<span class="title">Schedule editing</span>
	</div>

	<form  id=editform method="POST"  action="/KSHMY/CalendarEditServlet">

			営業所：<select id="branch" name="branch">
			<c:forEach var="e" items="${branch}" >
				<option value="${e}">${e}</option>
	        </c:forEach>
	    </select>
	    <button id="add" type="button" onclick="workspaceAdd()">+</button>
		<div id = "new"><input type="text" name="none" value="" placeholder="営業所">
		</div>

			<br>
			<label for="date">開始日時：</label>
			<input type="datetime-local"  id="date" name="start_date" value="${calendar.start_date}" />
			<br>
			<label for="date">終了日時：</label>
			<input type="datetime-local"  id="date" name="end_date" value="${calendar.end_date}" />
			<br>
			色：
			<input type="radio" name="color" value="e49aab"  id="colorimage1"><label for="colorimage1"></label>
			<input type="radio" name="color" value="9ae3ae" id="colorimage2"><label for="colorimage2"></label>
			<input type="radio" name="color" value="9ad0e3" id="colorimage3"><label for="colorimage3"></label><br>

			メモ：<textarea class="textarean" name = "memo">${calendar.memo}</textarea><br>

				<table>
				<tr>
				<td><input class="normal" type="submit" name="SUBMIT" value="更新"></td>
				<td><input class="reversal" type="submit" name="SUBMIT" value="削除"></td>
				</tr>
				</table>

			</form>
				<input type="hidden"  id = "branch_box"  value="${calendar.branch}">
				<input type="hidden"  id = "color_box"  value="${calendar.color}">
				<input type="hidden"  name = "number" value="${calendar.number}">

	</div>
</body>
<script src='/KSHMY/js/calendar_edit.js'></script>
</html>