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
	<table>
		<tr>
			<th>お気に入り</th>
			<th>ジャンル</th>
			<th>店名</th>
			<th>営業所</th>
			<th>総合評価</th>
			<th>個人評価</th>
			<th>メモ</th>
		</tr>
		<c:forEach var="e" items="${gourmetList}">
			<form id="edit-form" method="POST" action="/KSHMY/GourmetEditServlet">
			<tr>
				<td style="display: none"><input type="hidden" name="number"
					value="${e.number}"></td>

				<td>${e.favorite}</td>

				<td>${e.genre}</td>

				<td>${e.name}</td>

				<td>${e.branch}</td>

				<td>${e.avg_reputation}</td>

				<td>${e.reputation}</td>

				<td>${e.memo}</td>
				<td><input class="update" id="update" name="update"
					type="submit" value="編集"></td>
			</tr>
			</form>
		</c:forEach>
	</table>
</body>
</html>