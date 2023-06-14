package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Prefecture;

	public class PrefectureDAO {
		// 引数paramで検索項目を指定し、検索結果のリストを返す
		public Prefecture select(String param) {
			Connection conn = null;
			Prefecture pref = new Prefecture();

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "select * from prefecture WHERE "
					+ "NUMBER = ? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
				pStmt.setString(1, param);

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Prefecture pf = new Prefecture(
				rs.getString("NUMBER"),
				rs.getString("IDO"),
				rs.getString("KEIDO"),
				rs.getString("NAME")
				);
			}

		}

		catch (SQLException e) {
			e.printStackTrace();
			pref = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			pref = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					pref = null;
				}
			}
		}

		// 結果を返す
			return pref;


		}

	}
