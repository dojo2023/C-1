package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	// 引数user_cardで指定されたレコードを登録し、成功したらtrueを返す
	public boolean select(Users user_card) {
		Connection conn = null;
		boolean result = false;
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "insert into USERS (user_id,user_pw,name,workspase,prefecture_number,first,second,third) values (?, ?, ?, ?, ?, ?, ?, ?)";
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
				pStmt.setString(5, user_card.getPrefecture_number());
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

	// 引数で指定されたレコードを更新(編集)し、成功したらtrueを返す
	public boolean update(Users user_card) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "update USERS set user_id=?, user_pw=? ,name=?, workspace=?, prefecture_number=?, first=?, second=?, third=? where NUMBER=?";
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
			if (user_card.getPrefecture_number() != null && !user_card.getPrefecture_number().equals("")) {
				pStmt.setString(5, user_card.getPrefecture_number());
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
			pStmt.setString(9, user_card.getNumber());

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