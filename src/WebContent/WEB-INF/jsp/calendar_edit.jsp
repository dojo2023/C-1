<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー編集</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
</head>
<body>
<span class="title">Schedule editing</span>

 <form method="POST" action="/KSHMY/CalendarServlet">

<input class="normal" type="submit"  name="SUBMIT" value="更新">
<input class="reversal" type="submit"  name="SUBMIT" value="削除">


</form>
</body>
</html>