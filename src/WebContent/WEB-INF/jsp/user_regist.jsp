<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ユーザー登録画面</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
</head>
<body>
	<a href="/KSHMY/LoginServlet">＜戻る</a>
	<span class="title">User registration</span>
	<p>項目はすべて入力してください</p>
	<form id="regist-form" method="POST" action="/KSHMY/UserRegistServlet">
	<table>
	<tr><td><input type="text" name="name" value="" placeholder="氏名"></td></tr>
		<tr><td>所属地	                
		<select id="workspace" name="workspace">
			<option value="AA">AA</option>
			<option value="BB">BB</option>
			<option value="CC">CC</option>
	    </select><input class="add" id="add" name="add" type="submit" value="＋"> </td>
	    <td>都道府県
	    	<select id="workspace" name="workspace">
			<option value=1>東京都</option><option value=2>神奈川県</option><option value=3>埼玉県</option><option value=4>千葉県</option><option value=5>栃木県</option>
			<option value=6>群馬県</option><option value=7>茨城県</option>
			</select></td>
	    </tr>
	<tr><td><input type="text" name="user_id" value="" placeholder="ID"></td><td><input type="text" name="user_pw" value="" placeholder="パスワード"></td></tr>
		<tr><td>好きなジャンル</td></tr>
			<tr><td>第1位<select name="first">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option></td>
			<td>第2位<select name="secound">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option></td>
			<td>第3位<select name="third">
				<option value="和食">和食</option>
				<option value="洋食">洋食</option>
				<option value="中華">中華</option></td></tr>
	</table>
    	<input class="normal regist" id="regist" name="regist" type="submit" value="登録"> 
    </form>         
</body>
</html>