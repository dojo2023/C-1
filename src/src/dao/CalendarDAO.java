package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Calendar;
import model.LoginUser;

public class CalendarDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	// ユーザー個人個人の予定すべて取得する

	public List<Calendar> userselect(LoginUser user) { //userselectメソッド(ログインユーザーの番号を引数に）
		Connection conn = null;
		List<Calendar> cardList = new ArrayList<Calendar>();

		try {
			// JDBCドライバを読み込む  javaによるデータベース接続
			Class.forName("org.h2.Driver");

			// データベースに接続する                  URL                                     ユーザ名 PW
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "select * from Calendar WHERE users_number = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる

			pStmt.setInt(1, user.getNumber());


			// SQL文を実行し、検索結果を保持
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {  //nextメソッドを使用し取得した表のカラム名にカーソルがあっているのをネクストでデータの行にカーソルを変更する
				Calendar list = new Calendar(
						rs.getInt("USERS_NUMBER"),
						rs.getString("START_DATE"),
						rs.getString("END_DATE"),
						rs.getString("COLOR"),
						rs.getString("MEMO"),
						rs.getString("BRANCH")
						);

						cardList.add(list);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}

	// 日付とログインユーザーの番号からその日の予定を取得する
	public List<Calendar> dayselect(LoginUser user, Calendar date) { //userselectメソッド(ログインユーザーの番号, 選択された日付を引数に）
		Connection conn = null;
		List<Calendar> cardList = new ArrayList<Calendar>();

		try {
			// JDBCドライバを読み込む  javaによるデータベース接続
			Class.forName("org.h2.Driver");

			// データベースに接続する                  URL                                     ユーザ名 PW
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "select * from Calendar WHERE users_number = ? and start_date and end_date ";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる

			pStmt.setInt(1, user.getNumber());

			pStmt.setString(2, date.getStart_date());

			pStmt.setString(3, date.getEnd_date());


			// SQL文を実行し、検索結果を保持
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {  //nextメソッドを使用し取得した表のカラム名にカーソルがあっているのをネクストでデータの行にカーソルを変更する
				Calendar list = new Calendar(
						rs.getInt("USERS_NUMBER"),
						rs.getString("START_DATE"),
						rs.getString("END_DATE"),
						rs.getString("COLOR"),
						rs.getString("MEMO"),
						rs.getString("BRANCH")
						);

						cardList.add(list);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			cardList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			cardList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					cardList = null;
				}
			}
		}

		// 結果を返す
		return cardList;
	}



	// 引数cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean insert (Calendar schedule) {  //insertメソッド Calendar型の schedule
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する 後で変更必須
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			//SQL文を準備する（inset文を実行）
			String sql = "insert into Calendar(users_number, start_date, end_date, color, memo, branch)"
					+ "   values(?, ?, ?, ?, ?, ?)";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			pStmt.setInt(1,schedule.getUsers_number());

			pStmt.setString(2,schedule.getStart_date());

			pStmt.setString(3,schedule.getEnd_date());

			pStmt.setString(4,schedule.getColor());

			if (schedule.getMemo() != null) {
				pStmt.setString(5,schedule.getMemo());
			}
			else {
				pStmt.setString(5, null);
			}
			pStmt.setString(6,schedule.getBranch());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;



	}

	// 引数cardで指定されたレコードを更新し、成功したらtrueを返す
	public boolean update(Calendar schedule) {   // updateメソッド
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "update Calendar set START_DATE=?, END_DATE=?,  COLOR=?, MEMO=?, BRANCH=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, schedule.getStart_date());

			pStmt.setString(2, schedule.getEnd_date());

			pStmt.setString(3, schedule.getColor());

			if (schedule.getMemo() != null && !schedule.getMemo().equals("")) {
				pStmt.setString(4, schedule.getMemo());
			}
			else {
				pStmt.setString(4, null);
			}

			pStmt.setString(5, schedule.getBranch());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
	// 引数numberで指定されたレコードを削除し、成功したらtrueを返す
	public boolean delete(String number) {   //delateメソッド
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "delete from Calendar where NUMBER=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, number);

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}


}



