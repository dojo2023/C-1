/**
 *
 */

      document.addEventListener('DOMContentLoaded', function() {　
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
        	headerToolbar: {
                left: 'prev',		//上部左に前月へボタン
                center: 'title',	//上部真ん中に年月表示
                right: 'next'		//上部右に次月へボタン
            },
          　//休日を表示するか(true:土日の枠内が灰色になる)
            businessHours: true, events: event,

            //イベント情報の配列
/*          events: [
            	{
                    title: サインポスト',			//時間+営業所名
                    start: '2023-06-03',				//開始日
                    color: "rgb(83, 187, 195)",			//イベントの色
                    description: '場所:会議室',  	//メモ

                  },
                {
                      title: '13:00 B営業所',
                      start: '2023-06-26',
                      end: '2023-06-31',
                      color: "rgb(187, 83, 195)",
                      description: '場所：第五会議室',
                    }
              ],
*/
              //枠内クリックでクリックされた日付表示
              dateClick: function (jsEvent) {
            	  //jsEvent.dateStr:日付

				　//カレンダー登録ページが新しく開くプログラムを書く
                 window.location= 'CalendarRegistServlet?date='+ jsEvent.dateStr+ "T09:00";

             },

           　//予定クリックでクリックされた予定title+開始日付表示
             eventClick: function (jsEvent) {
            	//jsEvent.event.titler:クリックされたイベント
            	//jsEvent.event.startStr:クリックされたイベントの開始日


				//カレンダー編集ページが新しく開くプログラムを書く
				                 window.location=
                 'CalendarEditServlet?number='+ jsEvent.event.id;

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