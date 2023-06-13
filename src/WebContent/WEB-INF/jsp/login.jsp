<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ｜KSHMY</title>
</head>
<body>
	<main>
	     <section>
	        <form  method="POST" action="/KSHMY/LoginServlet"><!--フォームタグ-->
	           <table>
	              <tr>
	                <td>
	                    <!-- ID入力フォーム -->
	                    <input type="text" name="ID" placeholder = "username">
	                </td>
	              </tr>
	              <tr>
	                <td>
	                  <!-- PW入力フォーム -->
	                    <input type="password" name="PW" placeholder = "password">
	                </td>
	              </tr>
	              <tr>
	                <td>
	                  <input type="submit" name="LOGIN" value="LOGIN"><!--ログイン-->
	                </td>
	              </tr>
	              <tr>
	                <td>
                      <a href="/KSHMY/UserRegistServlet">新規登録はこちら</a>
	                </td>
	              </tr>
	           </table>
	        </form>
	    </section>
    </main>
  <!--メインここまで-->
</body>
</html>