/**
 * 
 */
	//今日の日付取得
	const dt = new Date();
	const year = dt.getFullYear();
	const month = (dt.getMonth()+1).toString().padStart(2, '0');
	const date = dt.getDate().toString().padStart(2, '0');
	
	//翌日の日付取得
	const dt2 = new Date(dt.setDate(dt.getDate() + 1)); 
	const year2 = dt2.getFullYear();
	const month2 = (dt2.getMonth()+1).toString().padStart(2, '0');
	const date2 = dt2.getDate().toString().padStart(2, '0');
	
	//ユーザごとの緯度経度取得
	const ido = document.getElementById('ido').value;
	const keido = document.getElementById('keido').value;
	
	const url = 'https://api.open-meteo.com/v1/jma?latitude='+ ido +'&longitude='+ keido +'&hourly=temperature_2m,weathercode&daily=weathercode&current_weather=true&past_days=3&timezone=Asia%2FTokyo';
	console.log(url);
	
	fetch(url)	//天気情報取得
	  .then(function (response) {
	    console.log(response);
	    return response.json();
	  })
	  .then(function (json) {
		//コンソールにobjectが書かれる（▼を押すと詳細が見れる）
	    console.log(json);
	    
		const now_date = year + "-" + month +"-"+ date; //今日の日付
		const next_date = year2 + "-" + month2 +"-"+ date2; //翌日の日付
		
 		let now = 0;
		for(let i = 0 ; i < json.daily.time.length ; i++)  {
			if(now_date === json.daily.time[i]){
				now = i;
			}
 		}
 		
		//今日の日付
		let today =(json.daily.time[now]);   
	    document.getElementById('today').innerHTML = today;

		//weatherコードに応じた天気
	    let weather = "天気予報：";	
		weather += weather_select(json,now); 	//下の方でweather_selectメソッドを定義してる
	    document.getElementById('today_weather').innerHTML = weather;

		//現在の気温
		let tempreture = ("気温:"+json.current_weather.temperature); 
		//document.getElementById('today_temp').innerHTML = tempreture;

		//翌日の分
		let nextday =(json.daily.time[now+1]);   
	    document.getElementById('nextday').innerHTML = nextday;
	    let nextday_weather = "天気予報：";	
		nextday_weather += weather_select(json,now+1); 	//下の方でweather_selectメソッドを定義してる
	    document.getElementById('nextday_weather').innerHTML = nextday_weather;
		let nextday_temp = ("気温:"+json.current_weather.temperature);  //仮　翌日の気温は存在しない（同じ時間帯の次の日を選択する）
		//document.getElementById('nextday_temp').innerHTML = nextday_temp;

	  });

	window.onload = function(){	　
			//タイトル部分(英語&二重下線)現在日時を書く
			const week = dt.getDay();
			const weekItems = ["Sat","Sun", "Mon", "Tue", "Wed", "Thu", "Fri"];
			const dayOfWeek = weekItems[week];
	
			const day = month +"/"+ date+"/"+ dayOfWeek +"'s schedule"; //今日の日付
			document.getElementById('title').innerHTML = day;
			
		}


	function weather_select(json,day){
		if(json.daily.weathercode[day] == 0){ return "快晴" + "&#x2600"; }
	    else if(json.daily.weathercode[day] == 1){ return "快晴" + "&#x2600"; }
	    else if(json.daily.weathercode[day] == 2){ return "一部曇" +  "&#x1f324"; }
	    else if(json.daily.weathercode[day] == 3){ return  "曇り" + "&#x2601"; }
	    else if(json.daily.weathercode[day] <= 49 && json.daily.weathercode[day] >=4){ return "霧" + "&#x1f32b"; }
	    else if(json.daily.weathercode[day] <= 59 && json.daily.weathercode[day] >=50){ return "霧雨" + "&#x1f327"; }
	    else if(json.daily.weathercode[day] <= 69 && json.daily.weathercode[day] >=60){ return "雨" + "&#x2614"; }
	    else if(json.daily.weathercode[day] <= 79 && json.daily.weathercode[day] >=70){ return "雪" + "&#x26c4"; }
	    else if(json.daily.weathercode[day] <= 84 && json.daily.weathercode[day] >=80){ return "俄か雨" + "&#x1f302"; }
	    else if(json.daily.weathercode[day] <= 94 && json.daily.weathercode[day] >=85 ){ return "雹" + "&#x2603"; }
	    else{ return "雷雨" + "&#x26a1"; }
	}


let str = "";

function msg() {
		if(tr1.textContent === '▼'){			
			str = "▲";						
		}else{
			str = "▼";
		}
		document.getElementById('tr1').innerHTML = str;
		document.getElementById('msg').classList.toggle('open');
}

