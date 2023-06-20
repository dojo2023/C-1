package test;

import dao.GourmetDAO;
import model.Gourmet;

public class GourmetDAOTest {
	public static void main(String[] args) {
		GourmetDAO dao = new GourmetDAO();

//		// select()のテスト
//		System.out.println("---------- select()のテスト ----------");
//
//		String keyWord = "";
//		int favorite = 0;
//		String[] checkedGenre = {"中華", "洋食", "和食", "その他"};
//		List<Gourmet> GourmetList2 = dao.select(keyWord, favorite, checkedGenre);
//		//System.out.println("テスト");
//		for (Gourmet list : GourmetList2) {
//		//System.out.println("テスト2");
//			System.out.println("number：" + list.getNumber());
//			System.out.println("users_number：" + list.getUsers_number());
//			System.out.println("name：" + list.getName());
//			System.out.println("branch：" + list.getBranch());
//			System.out.println("genre：" + list.getGenre());
//			System.out.println("reputation：" + list.getReputation());
//			System.out.println("favorite：" + list.getFavorite());
//			System.out.println("memo：" + list.getMemo());
//			System.out.println();
//		}

		//
	// insert_store()のテスト
		System.out.println("---------- insert_store()のテスト ----------");


		Gourmet insRecStore = new Gourmet( "Z店", "L営業所", "洋食");

		if (dao.insert_store(insRecStore) > 0) {
			System.out.println("登録成功！");}
		else {
			System.out.println("zzz");
		}
		// insert_reputation()のテスト
//		System.out.println("---------- reputation_store()のテスト ----------");
//
//
//		Gourmet insRecReputation = new Gourmet( auto);
//
//		if (dao.insert_store(insRecStore) > 0) {
//			System.out.println("登録成功！");}
//		else {
//			System.out.println("zzz");
//		}
//
//			List<Gourmet> GourmetList3 = dao.select(keyWord, favorite, checkedGenre);
//			for (Gourmet list : GourmetList3) {
//
//				System.out.println("name：" + list.getName());
//				System.out.println("branch：" + list.getBranch());
//				System.out.println("genre：" + list.getGenre());
//
//			}
//
//		}
//		else {
//			System.out.println("登録失敗！");
//		}
//
//		// insert_reputation()のテスト
//		System.out.println("---------- insert_reputation()のテスト ----------");
//
//		Gourmet insRecReputetion = new Gourmet(99, 7, 3, 0, "ピザ");
//
//		if (dao.insert_reputation(insRecReputetion)) {
//			System.out.println("登録成功！");
//			List<Gourmet> GourmetList4 = dao.select(keyWord, favorite, checkedGenre);
//			for (Gourmet list : GourmetList4) {
//				System.out.println("number：" + list.getNumber());
//				System.out.println("users_number：" + list.getUsers_number());
//				System.out.println("reputation：" + list.getReputation());
//				System.out.println("favorite：" + list.getFavorite());
//				System.out.println("memo：" + list.getMemo());
//			}
//		}
//		else {
//			System.out.println("登録失敗！");
//		}
//
//		// update_store()のテスト
//		System.out.println("---------- update_store()のテスト ----------");
//
//		Gourmet upRecStore = new Gourmet("Q店", "L営業所", "中華");
//
//		if (dao.update_store(upRecStore,1)) {
//			System.out.println("更新成功！");
//			List<Gourmet> GourmetList5 = dao.select(keyWord, favorite, checkedGenre);
//			for (Gourmet list : GourmetList5) {
//				System.out.println("name：" + list.getName());
//				System.out.println("branch：" + list.getBranch());
//				System.out.println("genre：" + list.getGenre());
//				System.out.println();
//			}
//		}
//		else {
//			System.out.println("更新失敗！");
//		}
//
//		// update_reputation()のテスト
//		System.out.println("---------- update_reputation()のテスト ----------");
//
//		Gourmet upRecReputation = new Gourmet(1, 1, 3, 0, "麻婆豆腐");
//
//		if (dao.update_reputation(upRecReputation)) {
//			System.out.println("更新成功！");
//			List<Gourmet> GourmetList6 = dao.select(keyWord, favorite, checkedGenre);
//			for (Gourmet list : GourmetList6) {
//				System.out.println("number：" + list.getNumber());
//				System.out.println("users_number：" + list.getUsers_number());
//				System.out.println("reputation：" + list.getReputation());
//				System.out.println("favorite：" + list.getFavorite());
//				System.out.println("memo：" + list.getMemo());
//				System.out.println();
//			}
//		}
//		else {
//			System.out.println("更新失敗！");
//		}

	}
}