<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			 		<li><a href="/KSHMY/GourmetServlet">一覧/検索</a></li>
			 		<li><a href="/KSHMY/GourmetRegistServlet">登録</a></li>
            </ul>
        </li>
        <li class="main_menu"><a href="/KSHMY/LogoutServlet">ログアウト</a></li>
		<li class="main_menu"><a href ="/KSHMY/UserEditServlet" >ユーザー</a></li>
    </ul>
</nav>
</header>
<!-- 
 <header>
 
  <div class="top">
 		<a href ="/KSHMY/MainServlet" ><img src = "/KSHMY/img/KMlogo.jpeg" width="100" height="100" alt="KSHMY"></a>
	  	<ul class = "list">
	 		<li class = "list-item "><a href="/KSHMY/MainServlet">メイン</a></li>
	 		<li class = "list-item "><a href="/KSHMY/CalendarServlet">カレンダー</a></li>
	 		<li class = "list-item sub">
	 			<span>グルメ</span>
		 		<ul class = "sub-list">
			 		<a href="/KSHMY/GourmetServlet"><li>一覧/検索</li></a>
			 		<li><a href="/KSHMY/GourmetRegistServlet">登録</a></li>
		 		</ul>
	 		</li>
	 		<li class = "list-item "><a href="/KSHMY/LogoutServlet">ログアウト</a></li>
		 	<li class = "list-item "><a href ="/KSHMY/UserEditServlet" >ユーザー</a></li>
	 	</ul>
 	</div>
  </header>
  -->
<div class="main">
<span class="title">〇〇/〇〇/Fri 's schedule</span>

	<form action="https://maps.google.com/">
		<input class="normal"type="submit" value="MAP">
	</form>


 	<form method="POST" action="/KSHMY/GourmetEditServlet">

		<input class="normal" type="submit"  name="SUBMIT" value="編集">

	</form>
	</div>
</body>
<script src='/KSHMY/js/common.js'></script>
</html>