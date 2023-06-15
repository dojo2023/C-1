package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private int number;	// ログイン時のユーザ番号

	public LoginUser() {
		this.number = 0;
	}

	public LoginUser(int number) {
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setUserId(int number) {
		this.number = number;
	}
}
