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
					width="300" height="200" alt="Business Card"></a>
			</h1>
			<div class=form>
				<span class="title">Login</span>
				<section>
					<form id="login_form" method="POST" action="/KSHMY/LoginServlet">
						<!--フォームタグ-->
						<table>
							<tr>
								<td>
									<!-- ID入力フォーム --> <input type="text" name="user_id"
									placeholder="username">
								</td>
							</tr>
							<tr>
								<td>
									<!-- PW入力フォーム --> <input type="password" name="user_pw"
									placeholder="password">
								</td>
							</tr>
							<tr>
								<td><input type="submit" name="LOGIN" value="LOGIN">
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