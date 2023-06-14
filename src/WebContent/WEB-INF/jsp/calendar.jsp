<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <!--フルカレンダーのcss情報をもらう -->
    <link rel = "stylesheet" href = "/KSHMY/css/common.css">
    <link href='/KSHMY/fullcalendar-5.11.5/lib/main.css' rel='stylesheet' />
    <link rel="stylesheet" href="/KSHMY/css/test.css"> <!--↑より先に書くとcssが上書きされるので注意-->
<title>カレンダーページ</title>
</head>
<body>
<span class="title">カレンダーページ</span>
	<!--カレンダー表示場所-->
    <div id='calendar'></div>
  </body>
  		<!--fullcalendarとtippyを使えるようにする(popperはtippyで必要)-->
		<script src="https://unpkg.com/@popperjs/core@2"></script>
		<script src="https://unpkg.com/tippy.js@6"></script>
      	<script src='/KSHMY/fullcalendar-5.11.5/lib/main.js'></script>

		<script src='/KSHMY/js/calendar.js'></script>
<form method="POST" action="/KSHMY/CalendarRegistServlet" onsubmit="return check()" >
<input type="submit" name="REGIST" value="登録"><br>
<form method="POST" action="/KSHMY/CalendarEditServlet" onsubmit="return check()" >
<input type="submit" name="EDIT" value="編集"><br>
</body>
</html>