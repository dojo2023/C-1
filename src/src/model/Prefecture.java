package model;

import java.io.Serializable;

//フィールド( オブジェクトが持つデータ)
public class Prefecture implements Serializable {
	private String number;
	private String ido;
	private String keido;
	private String name;

	// コンストラクタ (クラスのインスタンス生成時に実行されるメソッド)
	public Prefecture(String number, String ido, String keido, String name) {
		this.number = number;
		this.ido = ido;
		this.keido = keido;
		this.name = name;
	}

	// コンストラクタ（デフォルトコンストラクタ）
	public Prefecture() {
		this.number = "";
		this.ido = "";
		this.keido = "";
		this.name = "";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getIdo() {
		return ido;
	}

	public void setIdo(String ido) {
		this.ido = ido;
	}

	public String getKeido() {
		return keido;
	}

	public void setKeido(String keido) {
		this.keido = keido;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
