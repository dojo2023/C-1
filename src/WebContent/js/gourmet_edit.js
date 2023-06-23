/**
 *
 */
/*更新ボタン送信の際に確認ダイアログボックスの出現*/
function check(){
	return window.confirm("この内容で更新します。よろしいですか？");
}
/*お気に入り（★）クリックによるの画像の遷移*/
let str = "";

function favorite_change() {
		if(favorite.textContent === '☆'){
			str =  "★";
		document.getElementById('favorite').value = "1";
		}else{
			str =  "☆";
		document.getElementById('favorite').value = "0";
		}
		document.getElementById('favorite').innerHTML = str;
}