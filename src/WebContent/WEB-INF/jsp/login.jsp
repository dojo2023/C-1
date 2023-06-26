<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ｜KSHMY</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
<link rel="stylesheet" href="/KSHMY/css/login.css">
</head>
<body>
	<main>
		<div class=flex>
			<h1 class="logo">
				<a href="/KSHMY/LoginServlet"> <img src="/KSHMY/img/KMlogo.jpeg"
					width="400" height="300" alt="Business Card"></a>
			</h1>
			<div id="waku">
				<span class="logintitle">Login</span>
				<section>
					<form id="login_form" method="POST" action="/KSHMY/LoginServlet">
						<!--フォームタグ-->
						<table>
							<tr>
								<td>
									<!-- ID入力フォーム --> <input type="text" class="loginbox" name="user_id"
									placeholder="username">
								</td>
							</tr>
							<tr>
								<td>
									<!-- PW入力フォーム --> <input type="password" class="loginbox" name="user_pw"
									placeholder="password">
								</td>
							</tr>
							<tr>
								<td><input type="submit" class="normal" name="LOGIN" value="LOGIN">
									<!--ログイン--></td>
							</tr>
							<tr>
								<td><a href="/KSHMY/UserRegistServlet">新規登録はこちら</a></td>
							</tr>
						</table>
					</form>
				</section>
			</div>
		</div>
	</main>
	<!--メインここまで-->
</body>
<script src='/KSHMY/js/login.js'></script>
</html>