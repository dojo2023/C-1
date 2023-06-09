package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
				//fullcalendarでは日付跨ぎが2回無いと2日に渡ったイベントにならないため、end_dateに一日加算した値も用意する
				int yy = Integer.valueOf(rs.getString("END_DATE").substring(0,4));	 	//YYYY
				int mm = Integer.valueOf(rs.getString("END_DATE").substring(5,7));		//MM
				int dd = Integer.valueOf(rs.getString("END_DATE").substring(8,10));	//dd
				
				LocalDateTime datetime3 = LocalDateTime.of(yy, mm, dd, 00, 00);
				LocalDateTime date3 = datetime3.plusDays(1);		//endの翌日を格納
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
				String nextD = date3.format(dateTimeFormatter);		//endの翌日のString型に
				
				Calendar list = new Calendar(
						rs.getInt("NUMBER"),
						rs.getInt("USERS_NUMBER"),
						rs.getString("START_DATE").substring(0,10), 	//fullcalendar用に成型
						rs.getString("END_DATE").substring(0,10),		//fullcalendar用に成型
						rs.getString("START_DATE").substring(11,16), 	//fullcalendar用に成型
						rs.getString("END_DATE").substring(11,16),		//fullcalendar用に成型
						nextD,
						rs.getString("COLOR"),
						rs.getString("MEMO"),
						rs.getString("BRANCH")
						);

						cardList.add(list);
//				System.out.println(rs.getTimestamp("START_DATE"));

				//java.sql.Date date = rs.getDate("START_DATE");
				//date.toString();

				//java.sql.Timestamp time = rs.getTimestamp("START_DATE")
				//time.toString();
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
	public List<Calendar> dayselect(LoginUser user, String start,String end) { //userselectメソッド(ログインユーザーの番号, 選択された日付を引数に）
		Connection conn = null;
		List<Calendar> cardList = new ArrayList<Calendar>();

		try {
			// JDBCドライバを読み込む  javaによるデータベース接続
			Class.forName("org.h2.Driver");

			// データベースに接続する                  URL                                     ユーザ名 PW
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "SELECT * FROM CALENDAR WHERE users_number = ? "
					+ "	AND ( ? > START_DATE AND END_DATE > ?)"	//前日以前に開始して翌日以降に終了する予定
					+ "OR (START_DATE BETWEEN ?  AND ? )"		//今日から始まって翌日以降終わる可能性有りの予定
					+ "OR (END_DATE BETWEEN ?  AND ? ) "		//前日以前に始まって今日終わる予定
					+ "ORDER BY START_DATE" ;
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			pStmt.setInt(1, user.getNumber());
			pStmt.setString(2, start);
			pStmt.setString(3, end);
			pStmt.setString(4, start);
			pStmt.setString(5, end);
			pStmt.setString(6, start);
			pStmt.setString(7, end);


			// SQL文を実行し、検索結果を保持
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {  //nextメソッドを使用し取得した表のカラム名にカーソルがあっているのをネクストでデータの行にカーソルを変更する
				Calendar list = new Calendar(
						rs.getInt("USERS_NUMBER"),
						rs.getTimestamp("START_DATE"),
						rs.getTimestamp("END_DATE"),
						rs.getString("COLOR"),
						rs.getString("MEMO"),
						rs.getString("BRANCH"),
						rs.getString("START_DATE").replace("-", "/").substring(5, 16) + " ～ " + rs.getString("END_DATE").replace("-", "/").substring(5, 16)
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

	// 予定から詳細を取得する
		public Calendar editselect(int number) { //userselectメソッド(ログインユーザーの番号, 選択された日付を引数に）
			Connection conn = null;
			Calendar schedule = new Calendar();

			try {
				// JDBCドライバを読み込む  javaによるデータベース接続
				Class.forName("org.h2.Driver");

				// データベースに接続する                  URL                                     ユーザ名 PW
				conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

				// SQL文を準備する
				String sql = "select * from Calendar "
						+ "WHERE number = ?";
				PreparedStatement pStmt = conn.prepareStatement(sql);

				// SQL文を完成させる
				pStmt.setInt(1,number);

				// SQL文を実行し、検索結果を保持
				ResultSet rs = pStmt.executeQuery();

				// 結果表をコレクションにコピーする
				 rs.next() ;  //nextメソッドを使用し取得した表のカラム名にカーソルがあっているのをネクストでデータの行にカーソルを変更する
					schedule = new Calendar(
							rs.getInt("NUMBER"),
							rs.getInt("USERS_NUMBER"),
							rs.getTimestamp("START_DATE"),
							rs.getTimestamp("END_DATE"),
							rs.getString("COLOR"),
							rs.getString("MEMO"),
							rs.getString("BRANCH")
							);

			}
			catch (SQLException e) {
				e.printStackTrace();
				schedule = null;
			}
			catch (ClassNotFoundException e) {
				e.printStackTrace();
				schedule = null;
			}
			finally {
				// データベースを切断
				if (conn != null) {
					try {
						conn.close();
					}
					catch (SQLException e) {
						e.printStackTrace();
						schedule = null;
					}
				}
			}

			// 結果を返す
			return schedule;
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

			pStmt.setTimestamp(2,schedule.getStart_date());

			pStmt.setTimestamp(3,schedule.getEnd_date());

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
			String sql = "update Calendar set START_DATE=?, END_DATE=?,  COLOR=?, MEMO=?, BRANCH=?  where NUMBER=? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を完成させる
			pStmt.setTimestamp(1, schedule.getStart_date());

			pStmt.setTimestamp(2, schedule.getEnd_date());

			pStmt.setString(3, schedule.getColor());

			if (schedule.getMemo() != null && !schedule.getMemo().equals("")) {
				pStmt.setString(4, schedule.getMemo());
			}
			else {
				pStmt.setString(4, null);
			}

			pStmt.setString(5, schedule.getBranch());
			pStmt.setInt(6, schedule.getNumber());

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
	public boolean delete(int number) {   //delateメソッド
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
			pStmt.setInt(1, number);

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

	// 引数branchで検索項目を指定し、検索結果を返す　該当する営業所（DISTINCT被りなし）をリターンする
	public List<String> select_branch() {
		Connection conn = null;
		List <String> branch = new ArrayList<String>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "select DISTINCT branch from Calendar";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
			branch.add (rs.getString("BRANCH"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			branch = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			branch = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					branch= null;
				}
			}
		}

		// 結果を返す
		return branch;
	}

}



