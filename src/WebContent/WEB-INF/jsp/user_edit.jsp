<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザ編集画面</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
</head>
<body>

<!-- ヘッダー -->
<header>
	<h1><a href="/KSHMY/MainServlet"><img src="/KSHMY/img/KMlogo.jpeg" width="150" height="100" alt="KM"></a></h1>
	<span class="title">User information edition</span>
</header>
<!-- ヘッダーここまで -->

<a href="/KSHMY/MainServlet">＜メインへ戻る</a>

<form method="POST" action="/KSHMY/UserEditServlet">
	<input type="submit" id="save" name="save" value="保存">
</form>

</body>
</html>