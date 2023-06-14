<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>グルメ編集</title>
<link rel = "stylesheet" href = "/KSHMY/css/common.css">
</head>
<body>
	<span class="title">Gourumet editing</span>
	<form id="regist-form" method="POST" action="/KSHMY/GourmetServlet">
        <table>
        	<tr><td><input class="name" type="text" name="name" value="店名"></td>
                <td><input class="branch" type="text" name="branch" value="営業所"></td></tr>
		</table>
		
    	<input class="update" id="update" name="update" type="submit" value="更新"> 
    </form>  

</body>
</html>