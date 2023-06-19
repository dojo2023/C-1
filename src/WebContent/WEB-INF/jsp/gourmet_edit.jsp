<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グルメ編集</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
</head>
<body>
	<span class="title">Gourumet editing</span>
	<form id="regist-form" method="POST" action="/KSHMY/GourmetEditServlet">
		<table>
			<tr>
				<td><input class="name" type="text" name="name" value="店名"></td>
				<td><input class="branch" type="text" name="branch" value="営業所"></td>
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

		<input class="update" id="update" name="update" type="submit" value="更新">
	</form>

</body>
</html>