package model;

import java.io.Serializable;

public class Gourmet implements Serializable {
	private int number;
	private int users_number;
	private String name;
	private String branch;
	private String genre;
	private int reputation;
	private String favorite;
	private String memo;

	//引数ありのコンストラクタ
	public Gourmet(int number, int users_number, String name, String branch, String genre, int reputation, String favorite, String memo) {

		this.number = number;
		this.users_number = users_number;
		this.name = name;
		this.branch = branch;
		this.genre = genre;
		this.reputation = reputation;
		this.favorite = favorite;
		this.memo = memo;
	}
	//引数なし（デフォルト）コンストラクタ
	public Gourmet() {

		this.number = 0;
		this.users_number = 0;
		this.name = "";
		this.branch = "";
		this.genre = "";
		this.reputation = 0;
		this.favorite = "";
		this.memo = "";
	}



	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}


	public int getUsers_number() {
		return users_number;
	}
	public void setUsers_number(int users_number) {
		this.users_number = users_number;
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}


	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}


	public int getReputation() {
		return reputation;
	}
	public void setReputation(int reputation) {
		this.reputation = reputation;
	}


	public String getFavorite() {
		return favorite;
	}
	public void setFavorite(String favorite) {
		this.favorite = favorite;
	}


	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}


}
