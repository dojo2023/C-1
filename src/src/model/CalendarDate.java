package model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CalendarDate implements Serializable{
	private Timestamp start_date;
	private Timestamp end_date;

	public CalendarDate() {
		this.start_date = null;
		this.end_date = null;
	}

	public CalendarDate(Timestamp start_date, Timestamp end_date) {
		this.start_date = start_date;
		this.end_date = end_date;

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

}

