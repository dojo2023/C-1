package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.LoginUser;
import model.Users;


public class UsersDAO {
	// ログインできるならtrueを返す
	public boolean isLoginOK(Users users) {
		Connection conn = null;
		boolean loginResult = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SELECT文を準備する
			String sql = "select count(*) from USERS where user_id = ? and user_pw = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, users.getUser_id());
			pStmt.setString(2,users.getUser_pw());

			// SELECT文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// ユーザーIDとパスワードが一致するユーザーがいたかどうかをチェックする
			rs.next();
			if (rs.getInt("count(*)") == 1) {
				loginResult = true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			loginResult = false;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			loginResult = false;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					loginResult = false;
				}
			}
		}

		// 結果を返す
		return loginResult;
	}

	// 引数numberで検索項目を指定し、検索結果を返す　該当するユーザの登録情報をリターンする
	public Users select_User(LoginUser number) {
		Connection conn = null;
		Users card = new Users();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "select * from USERS WHERE NUMBER = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1, number.getNumber());

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			rs.next();
			card = new Users(
					rs.getString("NAME"),
					rs.getString("WORKSPACE"),
					rs.getInt("PREFECTURE_NUMBER"),
					rs.getString("USER_ID"),
					rs.getString("USER_PW"),
					rs.getString("FIRST"),
					rs.getString("SECOND"),
					rs.getString("THIRD"));

		} catch (SQLException e) {
			e.printStackTrace();
			card = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			card = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					card= null;
				}
			}
		}

		// 結果を返す
		return card;
	}

	// 引数workspaceで検索項目を指定し、検索結果を返す　該当する所属地（DISTINCT被りなし）をリターンする
	public List<String> select_workspace() {
		Connection conn = null;
		List <String> workspace = new ArrayList<String>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "select DISTINCT workspace from USERS";
			PreparedStatement pStmt = conn.prepareStatement(sql);


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while(rs.next()) {
			workspace.add (rs.getString("WORKSPACE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			workspace = null;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			workspace = null;
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
					workspace= null;
				}
			}
		}

		// 結果を返す
		return workspace;
	}
	// 引数user_cardで指定されたユーザ情報を登録し、成功したらtrueを返す
	public boolean insert(Users user_card) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "insert into USERS (user_id,user_pw,name,workspace,prefecture_number,first,second,third) values (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			//if (user_card.getUser_id() != null && !user_card.getUser_id().equals("")) {
			pStmt.setString(1, user_card.getUser_id());
			//			} else {
			//				pStmt.setString(1, null);
			//			}

			//			if (user_card.getCompany() != null && !user_card.getCompany().equals("")) {
			pStmt.setString(2, user_card.getUser_pw());
			//			} else {
			//				pStmt.setString(2, null);
			//			}
			//			if (user_card.getDepartment() != null && !user_card.getDepartment().equals("")) {
			pStmt.setString(3, user_card.getName());
			//			} else {
			//				pStmt.setString(3, null);
			//			}
			//			if (card.getPosition() != null && !card.getPosition().equals("")) {
			pStmt.setString(4, user_card.getWorkspace());
			//			} else {
			//				pStmt.setString(4, null);
			//			}
			//			if (card.getName() != null && !card.getName().equals("")) {
			pStmt.setInt(5, user_card.getPrefecture_number());
			//			} else {
			//				pStmt.setString(5, null);
			//			}
			//			if (card.getZipcode() != null && !card.getZipcode().equals("")) {
			pStmt.setString(6, user_card.getFirst());
			//			} else {
			//				pStmt.setString(6, null);
			//			}
			//			if (card.getAddress() != null && !card.getAddress().equals("")) {
			pStmt.setString(7, user_card.getSecond());
			//			} else {
			//				pStmt.setString(7, null);
			//			}
			//			if (card.getPhone() != null && !card.getPhone().equals("")) {
			pStmt.setString(8, user_card.getThird());
			//			} else {
			//				pStmt.setString(8, null);
			//			}

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}

	// 引数で指定されたユーザ情報を更新(編集)し、成功したらtrueを返す
	public boolean update(Users user_card, LoginUser number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "update USERS set USER_ID=?, USER_PW=? ,NAME=?, WORKSPACE=?, PREFECTURE_NUMBER=?, FIRST=?, SECOND=?, THIRD=? where NUMBER=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			// SQL文を完成させる

			if (user_card.getUser_id() != null && !user_card.getUser_id().equals("")) {
				pStmt.setString(1, user_card.getUser_id());
			} else {
				pStmt.setString(1, null);
			}
			if (user_card.getUser_pw() != null && !user_card.getUser_pw().equals("")) {
				pStmt.setString(2, user_card.getUser_pw());
			} else {
				pStmt.setString(2, null);
			}
			if (user_card.getName() != null && !user_card.getName().equals("")) {
				pStmt.setString(3, user_card.getName());
			} else {
				pStmt.setString(3, null);
			}
			if (user_card.getWorkspace() != null && !user_card.getWorkspace().equals("")) {
				pStmt.setString(4, user_card.getWorkspace());
			} else {
				pStmt.setString(4, null);
			}
			if (user_card.getPrefecture_number() != 0) {
				pStmt.setInt(5, user_card.getPrefecture_number());
			} else {
				pStmt.setString(5, null);
			}
			if (user_card.getFirst() != null && !user_card.getFirst().equals("")) {
				pStmt.setString(6, user_card.getFirst());
			} else {
				pStmt.setString(6, null);
			}
			if (user_card.getSecond() != null && !user_card.getSecond().equals("")) {
				pStmt.setString(7, user_card.getSecond());
			} else {
				pStmt.setString(7, null);
			}
			if (user_card.getThird() != null && !user_card.getThird().equals("")) {
				pStmt.setString(8, user_card.getThird());
			} else {
				pStmt.setString(8, null);
			}
			pStmt.setInt(9, number.getNumber());

			// SQL文を実行する
			if (pStmt.executeUpdate() == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		// 結果を返す
		return result;
	}
}