/**
 * 
 */
 
var formObj = document.getElementById('regist-form');
var errorMessageObj = document.getElementById('error_message');

 formObj.onsubmit = function(event) {
 	if (!((formObj.first.value !== formObj.second.value) && (formObj.second.value !== formObj.third.value) && (formObj.first.value !== formObj.third.value))) {
 		errorMessageObj.textContent = '※好きなジャンルは第1位から第3位まで被らないよう選択してください';
 		return false;

 	}
 	errorMessageObj.textContent = null;
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