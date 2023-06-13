<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang='ja'>
  <head>
    <meta charset="UTF-8">
  </head>
  <body>
  <p>天気</p>

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
	  });


    </script>
</html>