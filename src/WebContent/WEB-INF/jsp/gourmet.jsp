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
</head>
<body>
	<span class="title">Gourumet List</span>
	<c:forEach var="e" items="${gourmetList}">
		<form id="edit-form" method="GET" action="/KSHMY/GourmetEditServlet">
			<table>
				<tr>
					<td>店名<br> <input type="text" name="NAME"
						value="${e.name }"></td>
					<td>営業所<br> <input type="text" name="BRANCH"
						value="${e.branch}"></td>
				</tr>
				<tr>
					<td>お気に入り<br> <input type="text" name="GENRE"
						value="${e.genre}"></td>
					<td>ジャンル<br> <input type="text" name="REPUTATION"
						value="${e.reputation}"></td>
				</tr>
				<tr>
					<td>評価<br> <input type="text" name="FAVORITE"
						value="${e.favorite}"></td>
				</tr>
				<tr>
					<td>メモ<br> <input type="text" name="MEMO"
						value="${e.memo}"></td>
				</tr>
			</table>
			<input class="update" id="update" name="update" type="submit"
				value="編集">
		</form>
	</c:forEach>
	<form id="regist-form" method="GET"
		action="/KSHMY/GourmetRegistServlet">
		<input class="regist" id="regist" name="regist" type="submit"
			value="登録">
	</form>
</body>
</html>