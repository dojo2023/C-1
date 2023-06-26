<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.Gourmet"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グルメ編集</title>
<link rel="stylesheet" href="/KSHMY/css/common.css">
<link rel="stylesheet" href="/KSHMY/css/gourmet_edit.css">
</head>
<body>
	<header>
		<nav>
			<ul class="gnav_wrap">
				<li class="main_menu"><a href="/KSHMY/MainServlet"><img
						src="/KSHMY/img/KMlogo.jpeg" width="100" height="100" alt="KSHMY"></a>
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
	<div id="waku">
	<div class="title-box" id="title-box">
		<span class="title">Gourumet editing</span>
	</div>

	<form id="edit-form" method="POST" action="/KSHMY/GourmetEditServlet">
		<table>
			<tr>
				<td style="display: none">
				<input type="hidden" name="number"  value="${gourmetRecord.number}"></td>
				<td class="left">
				店名：
				<input class="name" type="text" name="number" value="${gourmetRecord.name}" readonly></td>
				<th>営業所：</th>
				<td> <select id="select_branch" name="branch">
							<option value="${gourmetRecord.branch}" >${gourmetRecord.branch}</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>お気に入り：<button type ="button" name="test"  class = "star" value = "${gourmetRecord.favorite}" id = "${gourmetRecord.store_number}" onclick = "favorite_change()">
					<c:if test="${gourmetRecord.favorite == 1}">★</c:if>
					<c:if test="${gourmetRecord.favorite == 0}">☆</c:if>
				</button></td>
				<th>ジャンル：</th>
				<td> <select name="genre">
						<option value="${gourmetRecord.genre}">${gourmetRecord.genre}</option>
						<option value="${gourmetRecord.genre}">その他</option>
				</select></td>
			</tr>
			<tr>
			<td>評価：
				 <select id="reputation" name="reputation">
						<option value=0>行ったことない</option>
						<option value=5>5 最高</option>
						<option value=4>4 うまい</option>
						<option value=3>3 普通</option>
						<option value=2>2 食べられる</option>
						<option value=1>1 もう行かない</option>
				</select></td>
			</tr>
			<tr>
				<td>メモ：</td>
			</tr>
			<tr>
					<td colspan="3"><textarea class="textarean" name="memo">${gourmetRecord.memo}</textarea></td>
			</tr>
		</table>

		<input class="regist" id="update" name="update" type="submit"
			value="更新">
	</form>
	</div>
	</div>
<hr>
 <div id="footer">
    <p>&copy;Copyright KSHMY. All rights reserved.</p>
 </div>

</body>
<script type="text/javascript">
var branchEl = document.getElementById( "reputation" ) ;
const calendarbranch_box = ${gourmetRecord.reputation};

window.onload = function(){
	//自分の評価が既に選択されてる状態にする
	for(var i=0; i<branchEl.length; i++){
		if(calendarbranch_box ==  branchEl.options[i].value ) {
	        branchEl.options[i].setAttribute("selected", "selected");
			break;
	    }
    }

}



function favorite_change() {
	let str = "";
	if('${gourmetRecord.favorite}' === '1'){
		str =  "☆";
	document.getElementById('${gourmetRecord.store_number}').value = "0";
	}else{
		str =  "★";
	document.getElementById('${gourmetRecord.store_number}').value = "1";
	}
	document.getElementById('${gourmetRecord.store_number}').innerHTML = str;
}
</script>
<script src='/KSHMY/js/common.js'></script>
<script src='/KSHMY/js/gourmet_edit.js'></script>
</html>