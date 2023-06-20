<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グルメ登録</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
<link rel="stylesheet" href="/KSHMY/css/user_regist.css">
</head>
<body>
	<span class="title">Gourmet Registration</span>
	<form id="regist-form" method="POST"
		action="/KSHMY/GourmetRegistServlet">
		<table>
			<tr>
				<td><input type="text" name="name" value="" placeholder="店名"></td>
				<td>営業所<select id="select_branch" name="branch">
						<c:forEach var="e" items="${branch}">
							<option value="${e}">${e}</option>
						</c:forEach>
						<option id="new_select" value="新規">新規</option>
				</select>
					<button id="add" type="button" onclick="branchAdd()">+</button></td>
			</tr>
			<tr>
				<td><input id="new" type="text" name="workspace" value=""
					placeholder="所属地"></td>
			</tr>
			<tr>
				<td>お気に入り<select name="favorite">
						<option value=0>〇</option>
						<option value=1>×</option>
				</select></td>
				<td>ジャンル<select>
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
</body>
<script src='/KSHMY/js/gourmet_regist.js'></script>
</html>