/**
 *
 */
 //コミット用
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

/*登録ボタン送信の際に確認ダイアログボックスの出現*/
function check(){
	return window.confirm("この内容で登録します。よろしいですか？");
}