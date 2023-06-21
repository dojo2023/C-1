'use strict';
  //htmlの'form'を抜き出してオブジェクトにし、submitボタンが押されたときにおこる動作を指定する
  document.getElementById('login_form').onsubmit = function(event) {
    const id = document.getElementById('login_form').user_id.value;
    const password = document.getElementById('login_form').user_pw.value;
    console.log(id);
    console.log(password);

    if (id === "" && password === "") {
      window.alert("IDとパスワードを入力してください!");
     // document.getElementById('error_message').textContent = "IDとパスワードを入力してください!";
    }
	else if (id === "" && password !== "") {
      	window.alert("IDを入力してください!");
    }
    else if (id !== "" && password === "") {
     	window.alert("パスワードを入力してください!");
    }
    else if (id !== "DOJO"){
    	window.alert("IDが間違っています！");
    }
    else if (password !== "password"){
    	window.alert("パスワードが間違っています!");
    }


  };/**
 *
 */