<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ja'>
<link rel="stylesheet" href="/KSHMY/css/calendar.css">
<div class=calendar>
	<head>
<meta charset="UTF-8">
	</head>
	<body>
		<p>天気</p>
		<div id="edit_area"></div>
		<div id="nitizi_area"></div>
		<div id="temperature_area"></div>

		<!-- チェックボックスのテスト -->
		<form action="/KSHMY/WeatherTestServlet" method="post">
			<input type="checkbox" name="checkbox" value="apple">りんご <input
				type="checkbox" name="checkbox" value="peach">もも <input
				type="checkbox" name="checkbox" value="banana">ばなな
			<p>
				<input type="submit" value="選択実行" style="WIDTH: 200px; HEIGHT: 20px">
			</p>
		</form>

		<script>
	
		const ido = 35.47;
		const keido = 139.63;
	//const url = 'https://api.open-meteo.com/v1/jma?latitude=35.69&longitude=139.69&hourly=temperature_2m,weathercode&daily=weathercode&current_weather=true&past_days=3&timezone=Asia%2FTokyo';
	const url = 'https://api.open-meteo.com/v1/jma?latitude='+ido+'&longitude='+keido+'&hourly=temperature_2m,weathercode&daily=weathercode&current_weather=true&past_days=3&timezone=Asia%2FTokyo';
	console.log("ido|keido:"+ido+"|"+keido);
	fetch(url)
	  .then(function (response) {
	    console.log(response);
	    return response.json();
	  })
	  .then(function (json) {
		//コンソールにobjectが書かれる（▼を押すと詳細が見れる）
	    console.log(json);
	    console.log("場所:"+json.timezone);
	    //let nitizi =json.current_weather.time;      // 現在の日時を表示する
	    console.log("現在の気温:"+json.current_weather.temperature);
	    console.log("配列0番目の天気コードを出す:"+json.hourly.weathercode[0]);
		console.log("現在の日時："+ json.current_weather.time);
	    let nitizi =("配列0番目の日時を出す:"+json.daily.time[0]);    //時間
	    document.getElementById('nitizi_area').innerHTML = nitizi;

	    const dt = new Date();
	    
	    const year = dt.getFullYear();
	    const month = (dt.getMonth()+1).toString().padStart(2, '0');
	    const date = dt.getDate().toString().padStart(2, '0');
		const now_date = year + "-" + month +"-"+ date; //今日の日付
		
		//翌日を取りたい　現在エラー
		const dt2 = new Date(dt.setDate(dt.getDate() + 1)); 
	    const year2 = dt2.getFullYear();
	    const month2 = (dt2.getMonth()+1).toString().padStart(2, '0');
	    const date2 = dt2.getDate().toString().padStart(2, '0');
		const next_date = year2 + "-" + month2 +"-"+ date2; //翌日の日付
		console.log("翌日"+next_date);

 		let now = 0;
/* 		for(let i = 0 ; i < json.daily.time.length ; i++)  {
			json.current_weather.time === json.daily.time[i];
			now = i;
 		} */
 		
		for(let i = 0 ; i < json.daily.time.length ; i++)  {
			if(now_date === json.daily.time[i]){
				now = i;
			}
 		}
 		
		let nitizi2 =("今日の日付:"+json.daily.time[now]);    //時間
	    document.getElementById('nitizi_area').innerHTML = nitizi2;
		console.log("現在の気温:"+json.current_weather.temperature);//日付の気温ではなく現在の時間の気温
		
		let tempreture = ("現在の気温:"+json.current_weather.temperature);
		document.getElementById('temperature_area').innerHTML = tempreture;
		
		console.log("天気コード:"+json.daily.weathercode[now]);


	    let str = "本日の天気予報：";
	    //HTMLのクラス名"edit_area"の場所に表示する
	    if(json.daily.weathercode[now] == 0){ str = "快晴" + "&#x2600"; }
	    else if(json.daily.weathercode[now] == 1){ str = "快晴" + "&#x2600"; }
	    else if(json.daily.weathercode[now] == 2){ str = "一部曇" +  "&#x1f324"; }
	    else if(json.daily.weathercode[now] == 3){ str =  "曇り" + "&#x2601"; }
	    else if(json.daily.weathercode[now] <= 49 && json.daily.weathercode[now] >=4){ str += "霧" + "&#x1f32b"; }
	    else if(json.daily.weathercode[now] <= 59 && json.daily.weathercode[now] >=50){ str += "霧雨" + "&#x1f327"; }
	    else if(json.daily.weathercode[now] <= 69 && json.daily.weathercode[now] >=60){ str += "雨" + "&#x2614"; }
	    else if(json.daily.weathercode[now] <= 79 && json.daily.weathercode[now] >=70){ str +=  "雪" + "&#x26c4"; }
	    else if(json.daily.weathercode[now] <= 84 && json.daily.weathercode[now] >=80){ str +=  "俄か雨" + "&#x1f302"; }
	    else if(json.daily.weathercode[now] <= 94 && json.daily.weathercode[now] >=85 ){ str += "雹" + "&#x2603"; }
	    else{ str = + "雷雨" + "&#x26a1"; }
	    document.getElementById('edit_area').innerHTML = str;

	  });



    </script>
</div>
</body>
</html>