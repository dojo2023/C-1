package model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;



public class Calendar implements Serializable {
	private int number;
	private int users_number;
	private Timestamp start_date;
	private Timestamp end_date;
	private String calendar_startD; 	//フルカレンダー用String（日付部分）
	private String calendar_endD;		//フルカレンダー用String（日付部分）
	private String calendar_startT; 	//フルカレンダー用String（時間部分）
	private String calendar_endT;		//フルカレンダー用String（時間部分）
	private String nextD;				//フルカレンダー用String（endに１日プラスしないと日付をまたいでイベント表示しない、endの翌日）
	private String color;
	private String memo;
	private String branch;
	private String time;
	private List<Gourmet> gourmetList;


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


	//fullCalendar用
	public Calendar(int number,int users_number,String calendar_startD, String calendar_endD, String calendar_startT, String calendar_endT,String nextD, String color, String memo, String branch) {
		this.number = number;
		this.users_number = users_number;
		this.calendar_startD= calendar_startD;
		this.calendar_endD = calendar_endD;
		this.calendar_startT= calendar_startT;
		this.calendar_endT = calendar_endT;
		this.nextD = nextD;
		this.color = color;
		this.memo = memo;
		this.branch = branch;
		System.out.println("next"+nextD);
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
		this.calendar_startD = "";
		this.calendar_endD = "" ;
		this.calendar_startT = "";
		this.calendar_endT = "" ;
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

	public String getCalendar_startD() {
		return calendar_startD;
	}

	public void setCalendar_startD(String calendar_startD) {
		this.calendar_startD = calendar_startD;
	}

	public String getCalendar_endD() {
		return calendar_endD;
	}

	public void setCalendar_endD(String calendar_endD) {
		this.calendar_endD = calendar_endD;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getNextD() {
		return nextD;
	}

	public void setNextD(String nextD) {
		this.nextD = nextD;
	}
	public String getCalendar_startT() {
		return calendar_startT;
	}

	public void setCalendar_startT(String calendar_startT) {
		this.calendar_startT = calendar_startT;
	}

	public String getCalendar_endT() {
		return calendar_endT;
	}

	public void setCalendar_endT(String calendar_endT) {
		this.calendar_endT = calendar_endT;
	}

	public List<Gourmet> getGourmetList() {
		return gourmetList;
	}

	public void setGourmetList(List<Gourmet> gourmetList) {
		this.gourmetList = gourmetList;
	}


}
