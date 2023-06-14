<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録画面</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
</head>
<body>
	<span class="title">User registration</span>
	<form id="regist-form" method="POST" action="/KSHMY/UserRegistServlet">
    	<input class="regist" id="regist" name="regist" type="submit" value="登録"> 
    </form>         
</body>
</html>