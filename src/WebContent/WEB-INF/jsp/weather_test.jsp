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
  <!-- チェックボックスのテスト -->
  <form action="/KSHMY/WeatherTestServlet" method="post">
    <input type="checkbox" name="checkbox" value="apple">りんご
    <input type="checkbox" name="checkbox" value="peach">もも
    <input type="checkbox" name="checkbox" value="banana">ばなな
    <p><input type="submit" value="選択実行" style="WIDTH: 200px; HEIGHT: 20px"></p>
	</form>

    <script>

	const url = 'https://api.open-meteo.com/v1/jma?latitude=35.69&longitude=139.69&hourly=temperature_2m,weathercode&daily=weathercode,temperature_2m_max&current_weather=true&past_days=7&timezone=Asia%2FTokyo';

	fetch(url)
	  .then(function (response) {
	    console.log(response);
	    return response.json();
	  })
	  .then(function (json) {
		//コンソールにobjectが書かれる（▼を押すと詳細が見れる）
	    console.log(json);
	    console.log("場所:"+json.timezone);
	    console.log("現在の時間:"+json.current_weather.time);
	    console.log("現在の気温:"+json.current_weather.temperature);
	    console.log("配列0番目の天気コードを出す:"+json.hourly.weathercode[0]);

	    let str = "エラー";
	    //HTMLのクラス名"edit_area"の場所に表示する
	    if(json.hourly.weathercode[0] == 0){ str = "快晴" + "&#x2600"; }
	    if(json.hourly.weathercode[0] == 1){ str = "快晴" + "&#x2600"; }
	    if(json.hourly.weathercode[0] == 2){ str = "一部曇" +  "&#x1f324"; }
	    if(json.hourly.weathercode[0] == 3){ str =  "曇り" + "&#x2601"; }
	    if(json.hourly.weathercode[0] <= 49){ str = "霧" + "&#x1f32b"; }
	    if(json.hourly.weathercode[0] <= 59){ str = "霧雨" + "&#x1f327"; }
	    if(json.hourly.weathercode[0] <= 69){ str = "雨" + "&#x2614"; }
	    if(json.hourly.weathercode[0] <= 79){ str =  "雪" + "&#x26c4"; }
	    if(json.hourly.weathercode[0] <= 84){ str =  "俄か雨" + "&#x1f302"; }
	    if(json.hourly.weathercode[0] <= 94){ str = "雹" + "&#x2603"; }
	    if(json.hourly.weathercode[0] <= 99){ str = "雷雨" + "&#x26a1"; }
	    document.getElementById('edit_area').innerHTML = str;

	  });



    </script>
    </div>
   </body>
</html>