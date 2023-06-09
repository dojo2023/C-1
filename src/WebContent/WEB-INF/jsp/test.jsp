<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ja'>
  <head>
    <meta charset="UTF-8">
    <!--フルカレンダーのcss情報をもらう -->
    <link href='/KSHMY/fullcalendar-5.11.5/lib/main.css' rel='stylesheet' />
    <link rel="stylesheet" href="/KSHMY/css/test.css"> <!--↑より先に書くとcssが上書きされるので注意-->
  </head>
  <body>
  	<!--カレンダー表示場所-->
    <div id='calendar'></div> 
  </body>
  		<!--fullcalendarとtippyを使えるようにする(popperはtippyで必要)-->
		<script src="https://unpkg.com/@popperjs/core@2"></script>
		<script src="https://unpkg.com/tippy.js@6"></script>
      	<script src='/KSHMY/fullcalendar-5.11.5/lib/main.js'></script>
    <script>

    　//[addEventListener('DOMContentLoaded']は恐らく、ページ読み込み時に実行する的なことが書いてある
      document.addEventListener('DOMContentLoaded', function() {　
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
        	headerToolbar: {
                left: 'prev',		//上部左に前月へボタン
                center: 'title',	//上部真ん中に年月表示
                right: 'next'		//上部右に次月へボタン
            },
          　//休日を表示するか(true:土日の枠内が灰色になる)
            businessHours: true,

            //イベント情報の配列
            events: [
            	{
                    title: '13:00　A営業所',			//時間+営業所名
                    start: '2023-06-03',				//開始日
                    color: "rgb(83, 187, 195)",			//イベントの色
                    description: '場所：第一会議室',  	//メモ
        				
                  },
                {
                      title: '13:00 B営業所',
                      start: '2023-06-26',
                      end: '2023-06-31',
                      color: "rgb(187, 83, 195)",
                      description: '場所：第五会議室',
                    }
              ],
              

              //枠内クリックでクリックされた日付表示
              dateClick: function (jsEvent) {
            	  //jsEvent.dateStr:日付
                  alert('日付がクリックされました。\n' + jsEvent.dateStr);
             },

           　//予定クリックでクリックされた予定title+開始日付表示
             eventClick: function (jsEvent) {
            	//jsEvent.event.titler:クリックされたイベント
            	//jsEvent.event.startStr:クリックされたイベントの開始日
                 alert(jsEvent.event.title+'がクリックされました。\n' + jsEvent.event.startStr);
             },             
             
             //イベントとカーソルが重なったらメモを表示
             eventDidMount: function(jsEvent){
             	  tippy(jsEvent.el, {
             	    content: jsEvent.event.extendedProps.description
             	  });
             	},

        });

        calendar.render();
      });

    </script>
</html>