package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GourmetDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Gourmet> select(String keyWord, String favorite, String[] checkedGenre) {
		Connection conn = null;
		List<Gourmet> GourmetList = new ArrayList<Gourmet>();

		if(keyWord == null) {
			keyWord = "";
		}

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "SELECT store.number, name, branch, genre, reputation, favorite, memo "
					+ "from store INNER JOIN reputation on store.number = reputation.number "
					+"WHERE name LIKE ? "
					+ "OR branch LIKE ? "
					+ "OR memo LIKE ?"
					+"AND favorite=?";

			//要検証！
			int count = 0;
			for (String genres : checkedGenre) {
				if (count == 0) {
					sql += " AND ( ";
				}
				sql += "genre = "+ genres;
				if (count != 0 && count != checkedGenre.length) {
					sql += " OR ";
				}
				count++;
				if (count == checkedGenre.length) {
					sql += ")";
				}
			}
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setString(1, "%" + keyWord + "%");
			pStmt.setString(2, "%" + keyWord + "%");
			pStmt.setString(3, "%" + keyWord + "%");
			pStmt.setString(4,  favorite );

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Gourmet list = new Gourmet(
				rs.getString("name"),
				rs.getString("branch"),
				rs.getString("memo")
				);
				GourmetList.add(list);
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			GourmetList = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			GourmetList = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					GourmetList = null;
				}
			}
		}

		// 結果を返す
		return GourmetList;

	}

	// 引数listで指定されたstoreレコードを登録し、成功したらtrueを返す
	public boolean insert(Gourmet list) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO STORE (name, branch,genre) VALUES (?, ?, ?);";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (list.getname() != null && !list.getname().equals("")) {
				pStmt.setString(1, list.getname());
			}
			else {
				pStmt.setString(1, null);
			}

			if (list.getbranch() != null && !list.getbranch().equals("")) {
				pStmt.setString(2, list.getbranch());
			}
			else {
				pStmt.setString(2, null);
			}

			if (list.getgenre() != null && !list.getgenre().equals("")) {
				pStmt.setString(3, list.getgenre());
			}
			else {
				pStmt.setString(3, null);
			}


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


	// 引数listで指定されたreputationレコードを登録し、成功したらtrueを返す
	public boolean insert(Gourmet list) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO reputation (number, users_number, reputation, favorite, memo) VALUES (?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (list.getreputation() != null && !list.getreputation().equals("")) {
				pStmt.setString(1, list.getreputation());
			}
			else {
				pStmt.setString(1, null);
			}

			if (list.getfavorite() != null && !list.getfavorite().equals("")) {
				pStmt.setString(2, list.getfavorite());
			}
			else {
				pStmt.setString(2, null);
			}

			if (list.getmemo() != null && !list.getmemo().equals("")) {
				pStmt.setString(3, list.getmemo());
			}
			else {
				pStmt.setString(3, null);
			}


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

	// 引数listで指定されたstoreレコードを更新し、成功したらtrueを返す
	public boolean update(Gourmet list) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE store SET name=?, branch=?, genre=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (list.getname() != null && !list.getname().equals("")) {
				pStmt.setString(1, list.getname());
			}
			else {
				pStmt.setString(1, null);
			}

			if (list.getbranch() != null && !list.getbranch().equals("")) {
				pStmt.setString(2, list.getbranch());
			}
			else {
				pStmt.setString(2, null);
			}

			if (list.getgenre() != null && !list.getbranch().equals("")) {
				pStmt.setString(3, list.getbranch());
			}
			else {
				pStmt.setString(3, null);
			}

			pStmt.setString(4, list.getnumber());

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


	// 引数listで指定されたreputationレコードを更新し、成功したらtrueを返す
	public boolean update(Gourmet list) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE reputation SET number=?, user_number=?, reputation=?, favorite=?, memo=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (list.getname() != null && !list.getname().equals("")) {
				pStmt.setString(1, list.getname());
			}
			else {
				pStmt.setString(1, null);
			}

			if (list.getbranch() != null && !list.getbranch().equals("")) {
				pStmt.setString(2, list.getbranch());
			}
			else {
				pStmt.setString(2, null);
			}

			if (list.getgenre() != null && !list.getbranch().equals("")) {
				pStmt.setString(3, list.getbranch());
			}
			else {
				pStmt.setString(3, null);
			}

			pStmt.setString(4, list.getnumber());

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
