package model;

import java.io.Serializable;

public class Users implements Serializable {
	private String number;
	private String user_id;
	private String user_pw;
	private String name;
	private String workspace;
	private String prefecture_number;
	private String first;
	private String second;
	private String third;

	//引数ありのコンストラクタ
	public Users(String number, String user_id, String user_pw, String name, String workspace, String prefecture_number,
			String first, String second, String third) {

		super();
		this.number = number;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.name = name;
		this.workspace = workspace;
		this.prefecture_number = prefecture_number;
		this.first = first;
		this.second = second;
		this.third = third;
	}

	//引数なしの（デフォルト）コンストラクタ
	public Users() {

		super();
		this.number = "";
		this.user_id = "";
		this.user_pw = "";
		this.name = "";
		this.workspace = "";
		this.prefecture_number = "";
		this.first = "";
		this.second = "";
		this.third = "";
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWorkspace() {
		return workspace;
	}

	public void setWorkspace(String workspace) {
		this.workspace = workspace;
	}

	public String getPrefecture_number() {
		return prefecture_number;
	}

	public void setPrefecture_number(String prefecture_number) {
		this.prefecture_number = prefecture_number;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getSecond() {
		return second;
	}

	public void setSecond(String second) {
		this.second = second;
	}

	public String getThird() {
		return third;
	}

	public void setThird(String third) {
		this.third = third;
	}

}