/**
 *
 */
let str = "error";
const add =  document.getElementById('add');
console.log(add.textContent);
function workspaceAdd() {
		if(add.textContent === '+'){
			str = "-";
		}else{
			str = "+";
		}
		document.getElementById('add').innerHTML = str;
		document.getElementById('new').classList.toggle('newOpen');
}