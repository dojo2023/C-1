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
 <div class="top">
 		<a href ="/KSHMY/MainServlet" ><img src = "/KSHMY/img/KMlogo.jpeg" width="100" height="100" alt="KSHMY"></a>
	  	<ul class = "list">
	 		<li class = "list-item "><a href="/KSHMY/MainServlet">メイン</a></li>
	 		<li class = "list-item "><a href="/KSHMY/CalendarServlet">カレンダー</a></li>
	 		<li class = "list-item sub"><span>グルメ</span>
		 		<ul class = "sub-list">
		 		<li><a href="/KSHMY/GourmetServlet">一覧/検索</a></li>
		 		<li><a href="/KSHMY/GourmetRegistServlet">登録</a></li>
		 		</ul>
	 		</li>
	 		<li class = "list-item "><a href="/KSHMY/LogoutServlet">ログアウト</a></li>
	 	</ul>
	 	<li class = "list-item "><a href ="/KSHMY/UserEditServlet" >ユーザー</a></li>
 	</div>
  </header>

<span class="title">〇〇/〇〇/Fri 's schedule</span>

	<form action="https://maps.google.com/">
		<input class="normal"type="submit" value="MAP">
	</form>


 	<form method="POST" action="/KSHMY/GourmetEditServlet">

		<input class="normal" type="submit"  name="SUBMIT" value="編集">

	</form>
</body>
<script src='/KSHMY/js/common.js'></script>
</html>