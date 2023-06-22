/* カレンダー編集ページのJavaScript */

/* ラジオボタン */
var elements = document.getElementsByName('color');
const color =  document.getElementById('color_box').value;

/* 営業所のプルダウン*/
var branchEl = document.getElementById( "branch" ) ;
const calendarbranch_box = document.getElementById('branch_box').value;


window.onload = onLoad;
	function onLoad(){
	console.log("実行");

	for (var i = 0; i < elements.length; i++){
	    if (color === elements.item(i). value) {
	  	  elements.item(i).checked = true;
	  	 break;
	    }
	}

	for(var i=0; i<branchEl.length; i++){
		if(calendarbranch_box ==  branchEl.options[i].value ) {
	        branchEl.options[i].setAttribute("selected", "selected");
			break;
	    }
    }
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

