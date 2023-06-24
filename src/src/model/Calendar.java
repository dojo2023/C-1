package model;

import java.io.Serializable;
import java.sql.Timestamp;



public class Calendar implements Serializable {
	private int number;
	private int users_number;
	private Timestamp start_date;
	private Timestamp end_date;
	private String color;
	private String memo;
	private String branch;
	private String time;


	//引数ありのコンストラクタ
	public Calendar(int users_number,Timestamp start_date, Timestamp end_date, String color, String memo, String branch) {
		this.users_number = users_number;
		this.start_date= start_date;
		this.end_date = end_date;
		this.color = color;
		this.memo = memo;
		this.branch = branch;
	}

	public Calendar(int number,int users_number,Timestamp start_date, Timestamp end_date, String color, String memo, String branch) {
		this.number = number;
		this.users_number = users_number;
		this.start_date= start_date;
		this.end_date = end_date;
		this.color = color;
		this.memo = memo;
		this.branch = branch;
	}
	
	public Calendar(int users_number,Timestamp start_date, Timestamp end_date, String color, String memo, String branch, String time) {
		this.users_number = users_number;
		this.start_date= start_date;
		this.end_date = end_date;
		this.color = color;
		this.memo = memo;
		this.branch = branch;
		this.time = time;
	}



	//引数なしの（デフォルト）コンストラクタ
	public Calendar() {
		this.number = 0;
		this.users_number = 0;
		this.start_date = null;
		this.end_date = null ;
		this.color = "";
		this.memo = "";
		this.branch = "";

	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
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





	public Timestamp getStart_date() {
		return start_date;
	}



	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}



	public Timestamp getEnd_date() {
		return end_date;
	}



	public void setEnd_date(Timestamp end_date) {
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
