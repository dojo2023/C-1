package model;

import java.io.Serializable;

public class Users implements Serializable {
	private String name;
	private String workspace;
	private int prefecture_number;
	private String user_id;
	private String user_pw;
	private String first;
	private String second;
	private String third;

	//引数ありのコンストラクタ
	public Users( String name, String workspace, int prefecture_number, String user_id, String user_pw,
			String first, String second, String third) {

		super();
		this.name = name;
		this.workspace = workspace;
		this.prefecture_number = prefecture_number;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.first = first;
		this.second = second;
		this.third = third;
	}

	//引数なしの（デフォルト）コンストラクタ
	public Users() {

		super();
		this.name = "";
		this.workspace = "";
		this.prefecture_number = 0;
		this.user_id = "";
		this.user_pw = "";
		this.first = "";
		this.second = "";
		this.third = "";
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

	public int getPrefecture_number() {
		return prefecture_number;
	}

	public void setPrefecture_number(int prefecture_number) {
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