<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Gourmet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グルメ編集</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
</head>
<body>
	<header>
		<nav>
			<ul class="gnav_wrap">
				<li class="main_menu"><a href="/KSHMY/MainServlet"><img
						src="/KSHMY/img/KMlogo.jpeg" width="100" height="100" alt="KSHMY"></a>
				</li>
				<li class="main_menu"><a href="/KSHMY/MainServlet">メイン</a></li>
				<li class="main_menu"><a href="/KSHMY/CalendarServlet">カレンダー</a>
				</li>
				<li class="main_menu">グルメ
					<ul class="sub_menu">
						<a href="/KSHMY/GourmetServlet"><li>一覧/検索</li></a>
						<a href="/KSHMY/GourmetRegistServlet"><li>登録</li></a>
					</ul>
				</li>
				<li class="main_menu"><a href="/KSHMY/LogoutServlet">ログアウト</a></li>
				<li class="main_menu"><a href="/KSHMY/UserEditServlet">ユーザー</a></li>
			</ul>
		</nav>
	</header>
	<span class="title">Gourumet editing</span>
	<c:forEach var="e" items="${gourmetRecord}">
		<form id="edit-form" method="POST" action="/KSHMY/GourmetEditServlet">
			<table>
				<tr>
					<td style="display: none"><input type="hidden" name="number"
						value="${e.number}"></td>
					<td>${e.branch}<input class="name" type="text" name="number"
						value=${e.number}></td>
					<td><input class="branch" type="text" name="branch"
						value=${e.branch}></td>
				</tr>
				<tr>
					<td><input class="favorite" type="text" name="favorite"
						value="お気に入り"></td>
					<td><input class="genre" type="text" name="genre" value="ジャンル"></td>
				</tr>
				<tr>
					<td><input class="reputation" type="text" name="reputation"
						value="評価"></td>
				</tr>
				<tr>
					<td><input class="memo" type="text" name="memo" value="メモ"></td>
				</tr>
			</table>

			<input class="update" id="update" name="update" type="submit"
				value="更新">
		</form>
	</c:forEach>

</body>
<script src='/KSHMY/js/common.js'></script>
</html>