<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Prefecture" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインページ</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
</head>
<body>
 <header>	  	
<nav>
    <ul class="gnav_wrap">
    	 <li class="main_menu">
    	 	<a href ="/KSHMY/MainServlet" ><img src = "/KSHMY/img/KMlogo.jpeg" width="100" height="100" alt="KSHMY"></a>
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

<div class="main">
	<span id = "title" class="title"></span>
	<div class = "syuzo">"${msg}"</div>
	<div class = "weather">
		<div id = "today"></div>
		<div id = "today_weather"></div>
		<div id = "today_temp"></div>
		<div id = "nextday"></div>
		<div id = "nextday_weather"></div>
		<div id = "nextday_temp"></div>
		
	</div>

	<form action="https://maps.google.com/">
		<input class="normal"type="submit" value="MAP">
	</form>


 	<form method="POST" action="/KSHMY/GourmetEditServlet">

		<input class="normal" type="submit"  name="SUBMIT" value="編集">

	</form>
	</div>
	<input type = "hidden" id="ido" value="${prefecture.ido}">
	<input type = "hidden" id="keido" value="${prefecture.keido}">
</body>
<script src='/KSHMY/js/common.js'></script>
<script src='/KSHMY/js/main.js'></script>
</html>