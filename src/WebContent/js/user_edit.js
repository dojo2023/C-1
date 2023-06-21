/**
 *
 */

var formObj = document.getElementById('edit-form');
var errorMessageObj = document.getElementById('error_message');

 formObj.onsubmit = function(event) {
 	if (!((formObj.first.value !== formObj.second.value) && (formObj.second.value !== formObj.third.value) && (formObj.first.value !== formObj.third.value))) {
 		errorMessageObj.textContent = '※好きなジャンルは第1位から第3位まで被らないよう選択してください';
 		return false;
 	}
 }


let str = "";

const pulldown = document.getElementById("select_workspace");

function workspaceAdd() {
		if(add.textContent === '+'){

			str = "-";
			pulldown.setAttribute("disabled", true);
			pulldown.setAttribute("name", "none");
			document.getElementById('new').setAttribute("name", "workspace");


		}else{

			str = "+";
			pulldown.setAttribute("name", "workspace");
			document.getElementById('new').setAttribute("name", "none");
			pulldown.removeAttribute("disabled");

		}
		document.getElementById('add').innerHTML = str;
		document.getElementById('new').classList.toggle('newOpen');
}



var select_workspaceEl = document.getElementById( "select_workspace" ) ;
var prefecture_numberEl = document.getElementById( "prefecture_number" ) ;

var firstEl = document.getElementById( "first" ) ;
var secondEl = document.getElementById( "second" ) ;
var thirdEl = document.getElementById( "third" ) ;

const cardworkspace = document.getElementById('cw').value;
const cardprefecture_number = document.getElementById('cp').value;
const cardfirst = document.getElementById('cf').value;
const cardsecond = document.getElementById('cs').value;
const cardthird = document.getElementById('ct').value;

 window.onload = onLoad;
	function onLoad(){
	console.log("実行");
//ページ読み込み時に実行したい処理
	for(var i=0; i<select_workspaceEl.length; i++){
		if(cardworkspace == select_workspaceEl.options[i].value ) {
	       select_workspaceEl.options[i].setAttribute("selected", "selected");
			break;
	    }
    }

   	for(var i=0; i<prefecture_numberEl.length; i++){
		if(cardprefecture_number == prefecture_numberEl.options[i].value ){
	        prefecture_numberEl.options[i].setAttribute("selected", "selected");
			break;
	    }
    }
    for(var i=0; i<firstEl.length; i++){
		if(cardfirst == firstEl.options[i].value ){
	        firstEl.options[i].setAttribute("selected", "selected");
			break;
	    }
    }
    for(var i=0; i<secondEl.length; i++){
		if(cardsecond == secondEl.options[i].value ){
	        secondEl.options[i].setAttribute("selected", "selected");
			break;
	    }
    }
    for(var i=0; i<thirdEl.length; i++){
		if(cardthird == thirdEl.options[i].value ){
	        thirdEl.options[i].setAttribute("selected", "selected");
			break;
	    }
    }
}
