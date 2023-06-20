<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー登録</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
<link rel = "stylesheet" href = "/KSHMY/css/calendar.css">
</head>
<body>
	<span class="title">Schedule registration</span>

 	<form method="POST" action="/KSHMY/CalendarServlet">

			<br>
			営業所：<select id="workspace" name="workspace">
			<option value="サインポスト">サインポスト</option>
			<option value="YSL">YSL</option>
			<option value="マネージビジネス">マネージビジネス</option>
			<option value="アーチ">アーチ</option>
			<option value="新規">新規</option>
	    </select><button id="add" type="button" onclick="workspaceAdd()">+</button>
		<div id = "new"><input type="text" name="workspace" value="" placeholder="営業所">
		</div>
			<br>
			開始日時：<input type="text" name="start_date" value="${Calendar.start_date}"><br>
			終了日時：<input type="text" name="end_date" value="${Calendar.end_date}"><br>
			色：<input type="text" name="color" value="${Calendar.color}"><br>
			 メモ：<input type="text" name="memo" value="${Calendar.memo}"><br>


				<input type="submit"  name="SUBMIT" value="登録">

</form>
</body>
</html>