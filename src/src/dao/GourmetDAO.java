package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Gourmet;

public class GourmetDAO {
	// 引数paramで検索項目を指定し、検索結果のリストを返す
	public List<Gourmet> select(String keyWord, int favorite, String[] checkedGenre, String kind, String order) {
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
			String sql = "SELECT store.number, users_number, name, branch, genre, reputation, AVG(reputation), favorite, memo "
					+ " from store INNER JOIN reputation on store.number = reputation.number "
					+" WHERE name LIKE ? "
					+ " OR branch LIKE ? "
					+ " OR memo LIKE ? ";




			//genreチェックボックス 要検証！
			int count = 0;
			for (String genres : checkedGenre) {
				if (count == 0) {
					sql += " AND ( ";
				}
				sql += "genre = "+ genres;
				count++;
				if (count != 1 || count != checkedGenre.length) {
					sql += " OR ";
				}
				if (count == checkedGenre.length) {
					sql += ")";
				}
			}

			//お気に入り絞り込み
			if(favorite != 2) {
				sql +=" AND favorite = ? ";
			}

			//グループ化と並び替えorderby
			sql += " GROUP BY store.number ";

			if(kind.equals("ジャンル")) {
				sql += " ORDER BY genre ";
			}else if(kind.equals("営業所")){
				sql += " ORDER BY branch ";
			}else if(kind.equals("店名")) {
				sql += " ORDER BY store ";
			}else if(kind.equals("総合評価")) {
				sql += " ORDER BY AVG(reputation) ";
			}else if(kind.equals("個人評価")) {
				sql += " ORDER BY reputation ";
			}

			if(order.equals("昇順")) {
				sql += " ASC ";
			}else {
				sql += " DESC ";
			}


			PreparedStatement pStmt = conn.prepareStatement(sql);



			// SQL文を完成させる
			pStmt.setString(1, "%" + keyWord + "%");
			pStmt.setString(2, "%" + keyWord + "%");
			pStmt.setString(3, "%" + keyWord + "%");

			int count2 = 4;
			for (String genres : checkedGenre) {
				pStmt.setString(count2, genres);
				count2++;
			}

			if(favorite != 2) {
				pStmt.setInt(count2,  favorite );
			}

			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();

			// 結果表をコレクションにコピーする
			while (rs.next()) {
				System.out.println("0");
				Gourmet list = new Gourmet(
						rs.getInt("store.number"),
						rs.getInt("users_number"),
						rs.getString("name"),
						rs.getString("branch"),
						rs.getString("genre"),
						rs.getInt("reputation"),
						rs.getInt("favorite"),
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

	// 引数listで検索項目を指定し、storeのリストを返す(reputationテーブルと結合)
	public List<Gourmet> select_GourmetList(Gourmet gourmet) {
		Connection conn = null;
		List<Gourmet> GourmetList = new ArrayList<Gourmet>();


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "SELECT store.number, users_number,  favorite, name, genre, branch, avg_reputation, reputation, memo "
					+ "from store "
					+ "INNER JOIN reputation "
					+ "on store.number = reputation.number "
					+ "JOIN (SELECT number, cast(avg(cast(reputation as decimal)) as decimal(10,1)) as avg_reputation from reputation group by number) as avg_table "
					+ "on store.number = avg_table.number "
					+ "where users_number = ? "
					+ "group by store.number "
					+ "order by genre ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1,  gourmet.getUsers_number());


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();


			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Gourmet card = new Gourmet(
						rs.getInt("number"),
						rs.getInt("users_number"),
						rs.getInt("favorite"),
						rs.getString("genre"),
						rs.getString("name"),
						rs.getString("branch"),
						rs.getDouble("avg_reputation"),
						rs.getInt("reputation"),
						rs.getString("memo")

						);
				GourmetList.add(card);
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

	//引数recordで編集するデータを選択
	public Gourmet select_record(Gourmet record) {
		Connection conn = null;
		Gourmet GourmetRecord = new Gourmet();


		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql ="SELECT store.number, users_number, name, branch, favorite, genre,  reputation, memo "
					+ "from store "
					+ "INNER JOIN reputation "
					+ "on store.number = reputation.number "
					+ "where users_number = ? and store.number = ? "
					+ "group by store.number "
					+ "order by genre ";

			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			pStmt.setInt(1,  record.getUsers_number());
			pStmt.setInt(2,  record.getStore_number());


			// SQL文を実行し、結果表を取得する
			ResultSet rs = pStmt.executeQuery();


			// 結果表をコレクションにコピーする
			while (rs.next()) {
				Gourmet card = new Gourmet(
						rs.getInt("number"),
						rs.getInt("users_number"),
						rs.getString("name"),
						rs.getString("branch"),
						rs.getInt("favorite"),
						rs.getString("genre"),
						rs.getInt("reputation"),
						rs.getString("memo")
						);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
			GourmetRecord = null;
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
			GourmetRecord = null;
		}
		finally {
			// データベースを切断
			if (conn != null) {
				try {
					conn.close();
				}
				catch (SQLException e) {
					e.printStackTrace();
					GourmetRecord = null;
				}
			}
		}

		// 結果を返す
		return GourmetRecord;

	}

	// 登録済み営業所（DISTINCT被りなし）をリターンする
	public List<String> select_branch() {
		Connection conn = null;
		List <String> branch = new ArrayList<String>();
		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "select DISTINCT branch from store";
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

	// 引数listで指定されたstoreレコードを登録し、成功したらnumber(主キー)を返す
	public int insert_store(Gourmet list) {
		Connection conn = null;
		int autoIncrementKey = 0;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO STORE (name, branch, genre) VALUES (?, ?, ?);";

			PreparedStatement pStmt = conn.prepareStatement(sql, java.sql.Statement.RETURN_GENERATED_KEYS);

			// SQL文を完成させる
			if (list.getName() != null && !list.getName().equals("")) {
				pStmt.setString(1, list.getName());
			}
			else {
				pStmt.setString(1, null);
			}

			if (list.getBranch() != null && !list.getBranch().equals("")) {
				pStmt.setString(2, list.getBranch());
			}
			else {
				pStmt.setString(2, null);
			}

			if (list.getGenre() != null && !list.getGenre().equals("")) {
				pStmt.setString(3, list.getGenre());
			}
			else {
				pStmt.setString(3, null);
			}


			// SQL文を実行する
			pStmt.executeUpdate();
			ResultSet res = pStmt.getGeneratedKeys();

			if(res.next()){
				autoIncrementKey = res.getInt(1);
				System.out.println(autoIncrementKey);
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
		return autoIncrementKey;
	}


	// 引数listで指定されたreputationレコードを登録し、成功したらtrueを返す
	public boolean insert_reputation(Gourmet list) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "INSERT INTO reputation (number, users_number, reputation, favorite, memo) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (list.getNumber() != 0 ) {
				pStmt.setInt(1, list.getNumber());
			}
			else {
				pStmt.setInt(1, 0);
			}

			if (list.getUsers_number() != 0 ) {
				pStmt.setInt(2, list.getUsers_number());
			}
			else {
				pStmt.setInt(2, 0);
			}

			if (list.getReputation() != 0 ) {
				pStmt.setInt(3, list.getReputation());
			}
			else {
				pStmt.setInt(3, 0);
			}

			if (list.getFavorite() != 0 ) {
				pStmt.setInt(4, list.getFavorite());
			}
			else {
				pStmt.setInt(4, 0);
			}

			if (list.getMemo() != null && !list.getMemo().equals("")) {
				pStmt.setString(5, list.getMemo());
			}
			else {
				pStmt.setString(5, null);
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
	public boolean update_store(Gourmet list,int number) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE store SET name=?, branch=?, genre=? WHERE number=? ";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる
			if (list.getName() != null && !list.getName().equals("")) {
				pStmt.setString(1, list.getName());
			}
			else {
				pStmt.setString(1, null);
			}

			if (list.getBranch() != null && !list.getBranch().equals("")) {
				pStmt.setString(2, list.getBranch());
			}
			else {
				pStmt.setString(2, null);
			}

			if (list.getGenre() != null && !list.getGenre().equals("")) {
				pStmt.setString(3, list.getGenre());
			}
			else {
				pStmt.setString(3, null);
			}

			pStmt.setInt(4, number);

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

	//	//店名から店番号を取ってくるメソッド
	//	public int select_store_number(Gourmet gourmet){
	//		Connection conn = null;
	//		int store_number = 0;
	//		try {
	//			// JDBCドライバを読み込む
	//			Class.forName("org.h2.Driver");
	//
	//			// データベースに接続する
	//			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");
	//
	//			// SQL文を準備する
	//			String sql = "select  number from store where name.equals  ?";
	//			PreparedStatement pStmt = conn.prepareStatement(sql);
	//
	//			pStmt.setInt(1, gourmet.getNumber());
	//
	//			// SQL文を実行し、結果表を取得する
	//			ResultSet rs = pStmt.executeQuery();
	//
	//				if(rs.next()) {
	//
	//					store_number = rs.getInt("number");
	//				}
	//
	//
	//		} catch (SQLException e) {
	//			e.printStackTrace();
	//			store_number = 0;
	//		} catch (ClassNotFoundException e) {
	//			e.printStackTrace();
	//			store_number = 0;
	//		} finally {
	//			// データベースを切断
	//			if (conn != null) {
	//				try {
	//					conn.close();
	//				} catch (SQLException e) {
	//					e.printStackTrace();
	//					store_number = 0;
	//				}
	//			}
	//		}
	//
	//		// 結果を返す
	//		return number;
	//	}


	// 引数listで指定されたreputationレコードを更新し、成功したらtrueを返す
	public boolean update_reputation(Gourmet list) {
		Connection conn = null;
		boolean result = false;

		try {
			// JDBCドライバを読み込む
			Class.forName("org.h2.Driver");

			// データベースに接続する
			conn = DriverManager.getConnection("jdbc:h2:file:C:/pleiades/workspace/data/KSHMY", "sa", "");

			// SQL文を準備する
			String sql = "UPDATE reputation SET reputation=?, favorite=?, memo=? WHERE number=? AND users_number=?";
			PreparedStatement pStmt = conn.prepareStatement(sql);

			// SQL文を完成させる

			if (list.getReputation() != 0 ) {
				pStmt.setInt(1, list.getReputation());
			}
			else {
				pStmt.setInt(1, 0);
			}

			if (list.getFavorite() != 0 ) {
				pStmt.setInt(2, list.getFavorite());
			}
			else {
				pStmt.setInt(2, 0);
			}

			if (list.getMemo() != null && !list.getMemo().equals("")) {
				pStmt.setString(3, list.getMemo());
			}
			else {
				pStmt.setString(3, null);
			}

			pStmt.setInt(4, list.getNumber());
			pStmt.setInt(5, list.getUsers_number());

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
