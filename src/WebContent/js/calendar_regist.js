/* カレンダー登録ページのJavaScript */


window.onload = onLoad;
	function onLoad(){
	console.log("実行");
	}


/*
	for (let i = 0; i < len; i++){
	    if (color === elements.item(i). value) {
	  	  elements.item(i).checked = true;
	  	 return;
	    }
	}
*/


/* 営業所のプラスマイナスボタン */
 let str = "";

const pulldown = document.getElementById("branch");

function workspaceAdd() {
		if(add.textContent === '+'){

			str = "-";
			pulldown.setAttribute("disabled", true);
			pulldown.setAttribute("name", "none");
			document.getElementById('new').setAttribute("name", "branch");


		}else{

			str = "+";
			pulldown.setAttribute("name", "branch");
			document.getElementById('new').setAttribute("name", "none");
			pulldown.removeAttribute("disabled");

		}
		document.getElementById('add').innerHTML = str;
		document.getElementById('new').classList.toggle('newOpen');
}

 /* 登録ボタンが押された際にアラート*/
 document.click.btn.addEventListener('click', function(e) {
    var result = window.confirm('この内容で登録しますか？');

    if( result === false ) {

		e.preventDefault();

    }

})

