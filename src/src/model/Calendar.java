package model;

import java.io.Serializable;



public class Calendar implements Serializable {
	private int users_number;
	private String start_date;
	private String end_date;
	private String color;
	private String memo;
	private String branch;


	//引数ありのコンストラクタ
	public Calendar(int users_number,String start_date, String end_date, String color, String memo, String branch) {

		this.users_number = users_number;
		this.start_date= start_date;
		this.end_date = end_date;
		this.color = color;
		this.memo = memo;
		this.branch = branch;
	}



	//引数なしの（デフォルト）コンストラクタ
	public Calendar() {

		this.users_number = 0;
		this.start_date= "";
		this.end_date = "";
		this.color = "";
		this.memo = "";
		this.branch = "";

	}



	public int getUsers_number() {
		return users_number;
	}




	public void setUsers_number(int users_number) {
		this.users_number = users_number;
	}





	public String getStart_date() {
		return start_date;
	}



	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}



	public String getEnd_date() {
		return end_date;
	}



	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}



	public String getMemo() {
		return memo;
	}



	public void setMemo(String memo) {
		this.memo = memo;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}

}
