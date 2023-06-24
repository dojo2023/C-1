/**
 * 
 */

/*お気に入り（★）クリックによるの画像の遷移*/
let str = "";

function favorite_change() {
		if(fav.textContent === '☆'){
			str =  "★";
		document.getElementById('favorite').value = "1";
		}else{
			str =  "☆";
		document.getElementById('favorite').value = "0";
		}
		fav.innerHTML = str;
}