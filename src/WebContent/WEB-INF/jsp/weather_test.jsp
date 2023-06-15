<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ja'>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
  <p>天気</p>
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
	  });


    </script>
</html>