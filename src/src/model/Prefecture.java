package model;

import java.io.Serializable;

//フィールド( オブジェクトが持つデータ)
public class Prefecture implements Serializable {
	private int number;
	private Double ido;
	private Double keido;
	private String name;

	// コンストラクタ (クラスのインスタンス生成時に実行されるメソッド)
	public Prefecture(int number, Double ido, Double keido, String name) {
		this.number = number;
		this.ido = ido;
		this.keido = keido;
		this.name = name;
	}

	// コンストラクタ（デフォルトコンストラクタ）
	public Prefecture() {
		this.number = 0;
		this.ido = 0.0;
		this.keido = 0.0;
		this.name = "";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Double getIdo() {
		return ido;
	}

	public void setIdo(Double ido) {
		this.ido = ido;
	}

	public Double getKeido() {
		return keido;
	}

	public void setKeido(Double keido) {
		this.keido = keido;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
