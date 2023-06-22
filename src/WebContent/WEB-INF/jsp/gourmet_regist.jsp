<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グルメ登録</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
<link rel="stylesheet" href="/KSHMY/css/gourmet_regist.css">
</head>
<body>
	<header>
		<nav>
			<ul class="gnav_wrap">
				<li class="main_menu"><a href="/KSHMY/MainServlet"><img
						src="/KSHMY/img/KMlogo.jpeg" width="150" height="100" alt="KSHMY"></a>
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

<div class = "conteinar">
<hr size="3" color="#404040">
	<div class="title-box" id="title-box">
		<span class="title">Gourmet Registration</span>
	</div>


	<form id="regist-form" method="POST"
		action="/KSHMY/GourmetRegistServlet">
		<table>
			<tr>
				<td>店名<input type="text" name="name" value=""></td>
				<td>営業所<select id="select_branch" name="branch">
						<c:forEach var="e" items="${branch}">
							<option value="${e}">${e}</option>
						</c:forEach>
				</select>
				</td>
			</tr>

			<tr>
				<td>お気に入り<select name="favorite">
						<option value=0>〇</option>
						<option value=1>×</option>
				</select></td>
				<td>ジャンル<select name="genre">
						<option value="和食">和食</option>
						<option value="洋食">洋食</option>
						<option value="中華">中華</option>
				</select></td>
			</tr>
			<tr>
				<td>評価<select name="reputation">
						<option value=0>行ったことない</option>
						<option value=5>5 最高</option>
						<option value=4>4 うまい</option>
						<option value=3>3 普通</option>
						<option value=2>2 食べられる</option>
						<option value=1>1 もう行かない</option>


				</select></td>
			</tr>
			<tr>
				<td><input class="memo" type="text" name="memo" value=""
					placeholder="メモ"></td>
			</tr>
		</table>

		<input class="regist" id="regist" name="regist" type="submit"
			value="登録">
	</form>
	</div>


<hr>
 <div id="footer">
    <p>&copy;Copyright KSHMY. All rights reserved.</p>
 </div>

</body>
<script src='/KSHMY/js/common.js'></script>
<script src='/KSHMY/js/gourmet_regist.js'></script>
</html>