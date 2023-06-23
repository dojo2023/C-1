/**
 *
 */
/* お気に入りボタンを★にする。 */
let str = "";
var favorite = document.getElementById('${e.store_number}').value;

function fav_change() {
		if(favorite === '1'){
			str =  "★";
		}else{
			str =  "☆";
		}
		document.getElementById('favorite').innerHTML = str;
}

/*
function favorite_change() {
		if(document.getElementById('favorite').value = "1"){
		str =  "★";
		}else{
		str =  "☆";
		}
		document.getElementById('favorite').innerHTML = str;
}*/