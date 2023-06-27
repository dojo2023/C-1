<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Prefecture" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインページ</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
<link rel = "stylesheet" href = "/KSHMY/css/main.css">
</head>
<body>
<div class="shutter"></div>
<div class="content">

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
		<div class ="img">
		<li class="main_menu"><a href ="/KSHMY/UserEditServlet" ><img src = "/KSHMY/img/user.png" alt="ユーザー"></a></li>
    	</div>
    </ul>
</nav>
	<hr size="3" color="#404040">
</header>

<div class = "conteinar">
</div>

<div class="main cloud">

	<div class = flex>
		<div class = "syuzo">
			<p class="text-background">激励メッセージ<button id = "tr1" class = "triangle" type="button" onclick="msg()">▲</button><br>
			<div id = "msg" class = "open">
				<div class = "box">
					<div id = "msg-top"> </div>
					<div id = "msg-middle">
						<div id = "msg-text">
							${msg}
						</div>
					</div>
					<div id = "msg-bottom"> </div>
				</div>
			</div>
		</div>
		<div class = "allSchedule">
		<div id="waku">
			<div class="title-box">
				<span id = "title" class="title"></span>
			</div>

			<c:forEach var="e" items="${todayList}" >
			<div class = "schedule">
				<div class="map">
					<div>${e.time}</div><form action="https://maps.google.com/">
					<input class="normal"type="submit" value="MAP"></form>
				</div>
				<div class="branch">営業所：<span class="text-normal">${e.branch}</span></div>
				<div class="memo">メモ　：<span class="text-normal">${e.memo}</span></div>
			グルメリスト<button class = "tr2 triangle" type="button" onclick="glist(this)">▼</button><br>
			<div class = "glist close">
				<table>
					<tr class = "tr">
						<th></th>
						<th>ジャンル</th>
						<th>店名</th>
						<th>総合評価</th>
						<th>個人評価</th>
						<th>メモ</th>
					</tr>

					<c:forEach var="e" items="${e.gourmetList}">
					<form id="edit-form" method="GET" action="/KSHMY/GourmetEditServlet">
					<tr><td style="display: none"><input type="hidden" name="number"
						value="${e.store_number}"></td>

					<td><input type ="hidden" name="test"  value = "${e.favorite}" id = "${e.store_number}" onclick = "fav_change()">
						<c:if test="${e.favorite == 1}">★</c:if>
						<c:if test="${e.favorite == 0}">☆</c:if>
					</td>

					<td>${e.genre}</td>
					
					<td>${e.name}</td>

					<td>${e.avg_reputation}</td>

					<td>${e.reputation}</td>

					<td>${e.memo}</td>
					<td><input class="update" id="update" name="update" type="submit" value="編集"></td></tr>
					</form>
					</c:forEach>

				</table>
			</div>
			</div>
			<hr>
			</c:forEach>
		</div>
		</div>

		<div class = "weather">
		<div id="waku2">
			<div class = "today-box">
				<div id = "today"></div>
				<div id = "today_weather"></div>
				<div id = "today_temp_max"></div>
				<div id = "today_temp_min"></div>

			</div>
			<div class = "nextday-box">
				<div id = "nextday"></div>
				<div id = "nextday_weather"></div>
				<div id = "nextday_temp_max"></div>
				<div id = "nextday_temp_min"></div>
			</div>
		</div>
		</div>
	</div>
</div>

	<div id = "today_weather_image"></div>

	<input type = "hidden" id="ido" value="${prefecture.ido}">
	<input type = "hidden" id="keido" value="${prefecture.keido}">

</div>
</body>
<script src='/KSHMY/js/common.js'></script>
<script src='/KSHMY/js/main.js'></script>
<script>
/* var button = document.getElementsByClassName('tr2');
let str = "";
for (i = 0; i < button.length; i++) {
  button[i].addEventListener("click", function() {
	  if(this.textContent === '▼'){
			str = "▲";
		}else{
			str = "▼";
		}
	this.innerHTML = str;
    this.next().classList.toggle('close');
  });
}*/
</script>
</html>