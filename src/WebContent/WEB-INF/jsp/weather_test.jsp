<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ja'>
<link rel="stylesheet"  href="/KSHMY/css/calendar.css">
<div class=calendar>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
  <p>天気</p>
  <div id="edit_area"></div>
  <div id="nitizi_area"></div>
  <!-- チェックボックスのテスト -->
  <form action="/KSHMY/WeatherTestServlet" method="post">
    <input type="checkbox" name="checkbox" value="apple">りんご
    <input type="checkbox" name="checkbox" value="peach">もも
    <input type="checkbox" name="checkbox" value="banana">ばなな
    <p><input type="submit" value="選択実行" style="WIDTH: 200px; HEIGHT: 20px"></p>
	</form>

    <script>

	const url = 'https://api.open-meteo.com/v1/jma?latitude=35.69&longitude=139.69&hourly=temperature_2m,weathercode&daily=weathercode&current_weather=true&past_days=3&timezone=Asia%2FTokyo';

	fetch(url)
	  .then(function (response) {
	    console.log(response);
	    return response.json();
	  })
	  .then(function (json) {
		//コンソールにobjectが書かれる（▼を押すと詳細が見れる）
	    console.log(json);
	    console.log("場所:"+json.timezone);
	    let nitizi =json.current_weather.time;
	    console.log("現在の気温:"+json.current_weather.temperature);
	    console.log("配列0番目の天気コードを出す:"+json.hourly.weathercode[0]);
	    // console.log("配列0番目の日時を出す:"+json.daily.time[0]);//時間

	     //const jstDate = new Date(Date.now( ) + ((new Date().getTimezoneOffset() + (9 * 60)) * 60 * 1000));
	    //document.getElementById('edit_area').innerHTML = jstDate;
	    document.getElementById('nitizi_area').innerHTML = nitizi;

	    let str = "エラー";
	    //HTMLのクラス名"edit_area"の場所に表示する
	    if(json.hourly.weathercode[0] == 0){ str = "快晴" + "&#x2600"; }
	    else if(json.hourly.weathercode[0] == 1){ str = "快晴" + "&#x2600"; }
	    else if(json.hourly.weathercode[0] == 2){ str = "一部曇" +  "&#x1f324"; }
	    else if(json.hourly.weathercode[0] == 3){ str =  "曇り" + "&#x2601"; }
	    else if(json.hourly.weathercode[0] <= 49 && json.hourly.weathercode[0] >=4){ str = "霧" + "&#x1f32b"; }
	    else if(json.hourly.weathercode[0] <= 59 && json.hourly.weathercode[0] >=50){ str = "霧雨" + "&#x1f327"; }
	    else if(json.hourly.weathercode[0] <= 69 && json.hourly.weathercode[0] >=60){ str = "雨" + "&#x2614"; }
	    else if(json.hourly.weathercode[0] <= 79 && json.hourly.weathercode[0] >=70){ str =  "雪" + "&#x26c4"; }
	    else if(json.hourly.weathercode[0] <= 84 && json.hourly.weathercode[0] >=80){ str =  "俄か雨" + "&#x1f302"; }
	    else if(json.hourly.weathercode[0] <= 94 && json.hourly.weathercode[0] >=85 ){ str = "雹" + "&#x2603"; }
	    else{ str = "雷雨" + "&#x26a1"; }
	    document.getElementById('edit_area').innerHTML = str;

	  });



    </script>
    </div>
   </body>
</html>