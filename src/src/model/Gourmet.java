package model;

import java.io.Serializable;

public class Gourmet implements Serializable {
	private int number;
	private int users_number;
	private String name;
	private String branch;
	private String genre;
	private int reputation;
	private int favorite;
	private String memo;
	private int store_number;
	private double avg_reputation;
	private int user_number;

	//引数ありのコンストラクタ
	public Gourmet(int number, int users_number, String name, String branch, String genre, int reputation, int favorite, String memo) {

		this.number = number;
		this.users_number = users_number;
		this.name = name;
		this.branch = branch;
		this.genre = genre;
		this.reputation = reputation;
		this.favorite = favorite;
		this.memo = memo;
	}
	//引数ありのコンストラクタ(Store)
	public Gourmet(String name, String branch, String genre) {

		this.name = name;
		this.branch = branch;
		this.genre = genre;
	}
	//引数ありのコンストラクタ(Reputation)
	public Gourmet(int number, int users_number, int reputation, int favorite, String memo) {

		this.number = number;
		this.users_number = users_number;
		this.reputation = reputation;
		this.favorite = favorite;
		this.memo = memo;
	}

	//引数アリのコンストラクタ(グルメ一覧ページ１)
	public Gourmet(int store_number, String name, String branch, String genre, int avg_reputation) {

		this.store_number = store_number;
		this.name = name;
		this.branch = branch;
		this.genre = genre;
		this.avg_reputation = avg_reputation;
	}

	//引数アリのコンストラクタ(グルメ一覧ページ２)
	public Gourmet(int user_number, int favorite, int reputation, String memo) {

		this.user_number = user_number;
		this.favorite = favorite;
		this.reputation = reputation;
		this.memo = memo;
	}


	public Gourmet( int store_number, int user_number, int favorite, String genre, String name, String branch,  double avg_reputation, int reputation, String memo) {

		this.store_number = store_number;
		this.user_number = user_number;
		this.favorite = favorite;
		this.genre = genre;
		this.name = name;
		this.branch = branch;
		this.avg_reputation = avg_reputation;
		this.reputation = reputation;
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
		this.favorite = 0;
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


	public int getFavorite() {
		return favorite;
	}
	public void setFavorite(int favorite) {
		this.favorite = favorite;
	}


	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}


	public int getStore_number() {
		return store_number;
	}
	public void setStore_number(int store_number) {
		this.store_number = store_number;
	}


	public double getAvg_reputation() {
		return avg_reputation;
	}
	public void setAvg_reputation(double avg_reputation) {
		this.avg_reputation = avg_reputation;
	}


	public int getUser_number() {
		return user_number;
	}
	public void setUser_number(int user_number) {
		this.user_number = user_number;
	}
}
