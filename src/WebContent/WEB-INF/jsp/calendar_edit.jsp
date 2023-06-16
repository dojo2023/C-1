<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カレンダー編集</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
</head>
<body>
	<span class="title">Schedule editing</span>

	<form method="POST" action="/KSHMY/CalendarServlet">


		<!-- テキストエリアとプルダウン  -->
		<div action="#">
			<br> 営業所：<input type="text" name="branch" list="basyo"
				placeholder="テキスト入力もしくはダブルクリック" autocomplete="off">
			<datalist id="basyo">
				<option value="サインポスト">
				<option value="YSL">
				<option value="マネージビジネス">
				<option value="アーチ">
			</datalist>
		</div>

		<div id=start_date>開始日時：</div>

		<div id=end_date>終了日時：</div>

		<div id=end_date>色：</div>

		<div id=end_date>メモ：</div>

		<input class="normal" type="submit" name="SUBMIT" value="更新">
		<input class="reversal" type="submit" name="SUBMIT" value="削除">


	</form>
</body>
</html>