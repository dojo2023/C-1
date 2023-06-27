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
<link rel="stylesheet" href="/KSHMY/css/gourmet.css">
</head>
<body>
 <header>
<nav class="haikei">
    <ul class="gnav_wrap">
    	 <li class="main_menu">
    	 	<a href ="/KSHMY/MainServlet" ><img src = "/KSHMY/img/KMlogo.jpeg" width="150" height="100" alt="KSHMY"></a>
    	</li>
        <li class="main_menu">
            <a href="/KSHMY/MainServlet">メイン</a>
        </li>
        <li class="main_menu">
            <a href="/KSHMY/CalendarServlet">カレンダー</a>
        </li>
        <li class="main_menu">
            グルメ
            <ul class="sub_menu">
			 		<a href="/KSHMY/GourmetServlet"><li>一覧/検索</li></a>
			 		<a href="/KSHMY/GourmetRegistServlet"><li>登録</li></a>
            </ul>
        </li>
        <li class="main_menu"><a href="/KSHMY/LogoutServlet">ログアウト</a></li>
		<li class="main_menu"><a href ="/KSHMY/UserEditServlet" >ユーザー</a></li>
    </ul>
</nav>
		<hr size="3" color="#404040">
</header>

<div class = "conteinar">


<div id=waku>
<div class = "title-box">
		<span class="title">Gourumet List</span>
	</div>
	<form method="POST" action="/KSHMY/GourmetServlet">
		<div class = "search">
	           	 <div class = "top">
	                <input class = "checkbox" type="checkbox" name="genre" value="和食" 	<c:if test="${genre[0]}">checked</c:if> >和食
	                <input class = "checkbox" type="checkbox" name="genre" value="洋食" 	<c:if test="${genre[1]}">checked</c:if> >洋食
	                <input class = "checkbox" type="checkbox" name="genre" value="中華" 	<c:if test="${genre[2]}">checked</c:if> >中華
	                <input class = "checkbox" type="checkbox" name="genre" value="その他" 	<c:if test="${genre[3]}">checked</c:if> >その他
	                &emsp;お気に入り
	                <select id="favorite" name="favorite">
						<option value=2>全て</option>
						<option value=1>★</option>
						<option value=0>☆</option>
					</select>
				</div>
				<div class="bottom">
	            	<div class="search-left">
	                並び替え
	                <select id="kind" name="kind">
	                    <option value="ジャンル">好きなジャンル</option>
	                    <option value="店名">店名</option>
	                    <option value="営業所">営業所</option>
	                    <option value="総合評価">総合評価</option>
	                    <option value="個人評価">個人評価</option>
	                </select>&ensp;
	                <select id="order" name="order">
	                    <option value="降順">降順</option>
	                    <option value="昇順">昇順</option>
	                </select>
	                </div>
					<div class="search-right">
	                <input class="search"type="text" name="keyword" value="${keyword}" placeholder="単一キーワードを入力" >
					<input class="search-btn" name="search-btn" type="submit" value="">
	                </div>
 	             </div>
			</div>
	</form>
	<table>
		<tr class = "tr">
			<th class="fav"></th>
			<th>ジャンル</th>
			<th>店名</th>
			<th>営業所</th>
			<th>総合評価</th>
			<th>個人評価</th>
			<th >メモ</th>
			<th ></th>
		</tr>

	<c:forEach var="e" items="${gourmetList}">
		<form id="edit-form" method="GET" action="/KSHMY/GourmetEditServlet">
		<tr><td style="display: none"><input type="hidden" name="number"
					value="${e.store_number}"></td>

				<td class="fav"><button class = "star" type ="button" name="test"  value = "${e.favorite}" id = "${e.store_number}" onclick = "fav_change()">
					<c:if test="${e.favorite == 1}">★</c:if>
					<c:if test="${e.favorite == 0}">☆</c:if>
				</button></td>

				<td class = "gen">${e.genre}</td>
				<td class = "name">${e.name}</td>
				<td class = "bran">${e.branch}</td>
				<td class = "ave_rep">${e.avg_reputation}</td>
				<td class = "rep">${e.reputation}</td>
				<td class = "memo">${e.memo}</td>

				<td><input class="update normal" id="update" name="update" type="submit" value="編集"></td></tr>
		</form>
	</c:forEach>
	</table>

</div>
</div>
<hr>
 <div id="footer">
    <p>&copy;Copyright KSHMY. All rights reserved.</p>
</div>
</body>

 <script type="text/javascript">

 /* チェックボックス */
 var elements = document.getElementsByName('genre');

 /* プルダウン*/
 var kindEl = document.getElementById( "kind" ) ;
 var orderEl = document.getElementById( "order" ) ;
 var favoriteEl = document.getElementById( "favorite" ) ;


 window.onload = onLoad;
 	function onLoad(){

	//並び替え項目プルダウンの選択
 	for(var i=0; i<kindEl.length; i++){
 		if("${kind}" ==  kindEl.options[i].value ) {
 			kindEl.options[i].setAttribute("selected", "selected");
 			break;
 	    }
     }
 	//昇順、降順プルダウンの選択
 	for(var i=0; i<orderEl.length; i++){
 		if("${order}" ==  orderEl.options[i].value ) {
 			orderEl.options[i].setAttribute("selected", "selected");
 			break;
 	    }
     }
 	//お気に入りプルダウンの選択
 	for(var i=0; i<favoriteEl.length; i++){
 		if("${favorite}" ==  favoriteEl.options[i].value ) {
 			favoriteEl.options[i].setAttribute("selected", "selected");
 			break;
 	    }
     }
 }

	let str = "";
	function fav_change() {
		if(test.value === '0'){
			str =  "★";
		document.getElementsByName('test').value = "1";
		}else{
			str =  "☆";
		document.getElementsByName('test').value = "0";
		}
		document.getElementsByName('test').innerHTML = str;
	}


</script>
<script src='/KSHMY/js/common.js'></script>
</html>