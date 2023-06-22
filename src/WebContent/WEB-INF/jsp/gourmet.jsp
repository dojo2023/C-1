<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Gourmet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グルメ一覧/検索ページ</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
<link rel="stylesheet" href="/KSHMY/css/gourmet.css">
</head>
<body>
 <header>
<nav>
    <ul class="gnav_wrap">
    	 <li class="main_menu">
    	 	<a href ="/KSHMY/MainServlet" ><img src = "/KSHMY/img/KMlogo.jpeg" width="150" height="100" alt="KSHMY"></a>
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

<div class = "conteinar">
<hr size="3" color="#404040">

	<div class = "title2">
		<span class="title">Gourumet List</span>
	</div>

	<table>
		<tr class = "tr">
			<th>お気に入り</th>
			<th>ジャンル</th>
			<th>店名</th>
			<th>営業所</th>
			<th>総合評価</th>
			<th>個人評価</th>
			<th>メモ</th>
		</tr>

	<c:forEach var="e" items="${gourmetList}">
		<form id="edit-form" method="GET" action="/KSHMY/GourmetEditServlet">
		<tr><td style="display: none"><input type="hidden" name="number"
					value="${e.store_number}"></td>

				<td>${e.favorite}</td>

				<td>${e.genre}</td>

				<td>${e.name}</td>

				<td>${e.branch}</td>

				<td>${e.avg_reputation}</td>

				<td>${e.reputation}</td>

				<td>${e.memo}</td>
				<td><input class="update" id="update" name="update" type="submit" value="編集"></td></tr>
		</form>
	</c:forEach>
	</table>

</div>

<hr>
 <div id="footer">
    <p>&copy;Copyright KSHMY. All rights reserved.</p>
 </div>

</body>
<script src='/KSHMY/js/common.js'></script>
</html>