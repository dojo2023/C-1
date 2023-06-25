/**
 *
 */
 


      document.addEventListener('DOMContentLoaded', function() {　
      var title = [ "AAAAA", "BBBBB"]; 
      var color = [ "e35265", "7ee090"]; 
      console.log(title[0]);
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
            		id:0,						//カレンダー番号(Calendar.javaにnumber有りのコンストラクタ作って貰う)
                    title: title[0],			//時間+営業所名
                    start: '2023-06-03',				//開始日
                    color: "#"+color[0],			//イベントの色
                    description: '場所：第一会議室',  	//メモ

                  },
                {
                	  id:1,
                      title: title[1],
                      start:"2023-06-12T10:30:00-05:00",
                	  end:"2023-06-12T12:30:00-05:00",
                      color: "#"+color[1],
                      description: '場所：第五会議室',
                    }
              ],


              //枠内クリックでクリックされた日付表示
              dateClick: function (jsEvent) {
            	  //jsEvent.dateStr:日付
                  alert('日付がクリックされました。\n' + jsEvent.dateStr);

				　//カレンダー登録ページが新しく開くプログラムを書く
                 window.open(
                 'CalendarRegistServlet');

             },

           　//予定クリックでクリックされた予定title+開始日付表示
             eventClick: function (jsEvent) {
            	//jsEvent.event.titler:クリックされたイベント
            	//jsEvent.event.startStr:クリックされたイベントの開始日
                // alert(jsEvent.event.title+'がクリックされました。\n');
                
                alert("id:" + jsEvent.event.id);


				//カレンダー編集ページが新しく開くプログラムを書く
				                 window.open(
                 'CalendarEditServlet');

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