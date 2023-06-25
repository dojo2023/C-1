<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- C:を使うという宣言 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--フルカレンダーのcss情報をもらう -->
<link rel="stylesheet" href="/KSHMY/css/common.css">
<link href='/KSHMY/fullcalendar-5.11.5/lib/main.css' rel='stylesheet' />
<link rel="stylesheet" href="/KSHMY/css/test.css">
<!--↑より先に書くとcssが上書きされるので注意-->
<title>カレンダーページ</title>
</head>
<body>
 <header>
<nav>
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
</header>

<div class = "conteinar">
	<hr size="3" color="#404040">
	<c:forEach var="c" items="${cardlist}">
	${c.number}
	</c:forEach>
	<%-- <c:forEach var="c" items="${cardlist}">

		<input type = "hidden" id = "start_date" value="${c.start_date}">
		<input type = "hidden" id = "end_date" value="${c.end_date}">
		<input type = "hidden" id = "color" value="${c.color}">
		<input type = "hidden" id = "memo" value="${c.memo}">
		<input type = "hidden" id = "branch" value="${c.branch}">

	</c:forEach> --%>
	<br>

	<!--カレンダー表示場所-->
	<div id='calendar'></div>
</div>
</body>
<!--fullcalendarとtippyを使えるようにする(popperはtippyで必要)-->
<script src="https://unpkg.com/@popperjs/core@2"></script>
<script src="https://unpkg.com/tippy.js@6"></script>
<script src='/KSHMY/fullcalendar-5.11.5/lib/main.js'></script>

<script src='/KSHMY/js/calendar.js'></script>
<script type="text/javascript">

/* let event = [
{
    title: 'サインポスト',			//時間+営業所名
    start: '2023-06-03',				//開始日
    //color: "rgb(83, 187, 195)",			//イベントの色
    //description: '場所:会議室',  	//メモ

  },
{
      title: '13:00 B営業所',
      start: '2023-06-26',
      end: '2023-06-31',
      color: "rgb(187, 83, 195)",
      description: '場所：第五会議室',
  }
]; */


    let event = [

	<c:forEach var="c" items="${cardlist}">
	{
		id: ${c.number},
	   	title: '${c.calendar_startT}'+' '+'${c.branch}',
		start: '${c.calendar_startD}',
		end: '${c.nextD}',	//calendar_endDの翌日
		color: "#"+"${c.color}",
		description: '${c.memo}'+
		' ('+'${c.calendar_startD}'.substring(8,10)+'日'+'${c.calendar_startT}'+'～'+'${c.calendar_endD}'.substring(8,10)+'日'+'${c.calendar_endT}'+')' ,

	},
	</c:forEach>


	];





</script>
<script src='/KSHMY/js/common.js'></script>
</html>