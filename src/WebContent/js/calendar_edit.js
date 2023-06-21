/* カレンダー編集ページのJavaScript */

/* ラジオボタン */
const color =  document.getElementById('color_box').value;

let elements = document.getElementsByName('color');
let len = elements.length;
let checkValue = '';

window.onload = function(){
	for (let i = 0; i < len; i++){
	    if (color === elements.item(i). value) {
	  	  elements.item(i).checked = true;
	  	 return;
	    }
	}
}


/* 営業所のプルダウン */
const branch =  document.getElementById('branch_box').value;

let elements = document.getElementsByName('branch');
let len = elements.length;
let checkValue = '';

window.onload = function(){
	for (let i = 0; i < len; i++){
	    if (color === elements.item(i). value) {
	  	  elements.item(i).checked = true;
	  	 return;
	    }
	}
}



/* 営業所のプラスマイナスボタン */
 let str = "";

const pulldown = document.getElementById("select_workspace");

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

