/**
 * 
 */
let str = "";

const pulldown = document.getElementById("select_workspace");

function workspaceAdd() {
		if(add.textContent === '+'){
		console.log("テキストボックス表示！");
			console.log("プルダウンのname:"+pulldown.getAttribute("name"));
			console.log("テキストボックスのname変更前:"+document.getElementById('add').getAttribute("name"));
			
			str = "-";
			pulldown.setAttribute("disabled", true);
			pulldown.setAttribute("name", "none");
			document.getElementById('new').setAttribute("name", "workspace");
			
			console.log("プルダウンのname変更後:"+pulldown.getAttribute("name"));
			console.log("テキストボックスのname変更後:"+document.getElementById('add').getAttribute("name"));
			
		}else{
			console.log("テキストボックス非表示！");
			console.log("プルダウンのname変更前:"+pulldown.getAttribute("name"));
			console.log("テキストボックスのname変更前:"+document.getElementById('add').getAttribute("name"));
			
			str = "+";
			pulldown.setAttribute("name", "workspace");
			document.getElementById('new').setAttribute("name", "none");
			pulldown.removeAttribute("disabled");
			
			console.log("プルダウンのname変更後:"+pulldown.getAttribute("name"));
			console.log("テキストボックスのname変更後:"+document.getElementById('add').getAttribute("name"));
		}
		document.getElementById('add').innerHTML = str;
		document.getElementById('new').classList.toggle('newOpen');
}