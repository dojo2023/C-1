package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Prefecture;

	public class PrefectureDAO {
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public List<Prefecture> select(Prefecture param) {
			Connection conn = null;
			List<Prefecture> cardList = new ArrayList<Prefecture>();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "select * from prefecture WHERE "
					+ "NUMBER LIKE ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(param.getNumber());

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
		}
	}
