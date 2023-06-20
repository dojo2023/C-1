<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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

		<br> 営業所：<select id="workspace" name="workspace">

		</select>
		<button id="add" type="button" onclick="workspaceAdd()">+</button>
		<div id="new">
			<input type="text" name="workspace" value="" placeholder="営業所">
		</div>
		<br>
		開始日時：<input type="text" name="start_date" value="${Calendar.start_date}"><br>
		終了日時：<input type="text" name="end_date" value="${Calendar.end_date}"><br>

		色：<label><input type="radio" name="color" value="color1">青</label>
		<label><input type="radio" name="color" value="color2">緑</label>
		<label><input type="radio" name="color" value="color3">赤</label><br>

		メモ：
		<textarea name="memo">${Calendar.memo}</textarea>
		<br> <input type="submit" name="SUBMIT" value="登録">

	</form>
</body>
<script src='/KSHMY/js/common.js'></script>
</html>