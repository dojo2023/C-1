<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グルメ登録</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
</head>
<body>
	<span class="title">Gourmet Registration</span>
	<form id="regist-form" method="POST" action="/KSHMY/GourmetServlet">
		<table>
			<tr>
				<td><input class="name" type="text" name="name" value="店名"></td>
				<td><input class="branch" type="text" name="branch" value="営業所"></td>
			</tr>
			<tr>
			<td><input class="favorite" type="text" name="favorite" value="お気に入り"></td>
			<td><input class="genre" type="text" name="genre" value="ジャンル"></td>
			</tr>
			<tr>
			<td><input class="reputation" type="text" name="reputation" value="評価"></td>
			</tr>
			<tr>
			<td><input class="memo" type="text" name="memo" value="メモ"></td>
			</tr>
		</table>

		<input class="regist" id="regist" name="regist" type="submit" value="登録">
	</form>
</body>
</html>