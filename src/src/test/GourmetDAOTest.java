package test;

import java.util.List;

import dao.GourmetDAO;
import model.Gourmet;

public class GourmetDAOTest {
	public static void main(String[] args) {
		GourmetDAO dao = new GourmetDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		List<Gourmet> GourmetList2 = dao.select(new Gourmet());
		for (Gourmet list : GourmetList2) {
			System.out.println("number：" + list.getnumber());
			System.out.println("users_number：" + list.getusers_number());
			System.out.println("name：" + list.getname());
			System.out.println("branch：" + list.getbranch());
			System.out.println("genre：" + list.getgenre());
			System.out.println("reputation：" + list.getreputation());
			System.out.println("favorite：" + list.getfavorite());
			System.out.println("memo：" + list.getmemo());
			System.out.println();
		}

		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Gourmet insRec = new Gourmet("0011", "7", "L営業所", "洋食", "3", "0", "ピザ");

		if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			List<Gourmet> GourmetList3 = dao.select(insRec);
			for (Gourmet list : GourmetList3) {
				System.out.println("number：" + list.getnumber());
				System.out.println("users_number：" + list.getusers_number());
				System.out.println("name：" + list.getname());
				System.out.println("branch：" + list.getbranch());
				System.out.println("genre：" + list.getgenre());
				System.out.println("reputation：" + list.getreputation());
				System.out.println("favorite：" + list.getfavorite());
				System.out.println("memo：" + list.getmemo());
			}
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Gourmet upRec = new Gourmet("0011", "7", "L営業所", "中華", "3", "0", "麻婆豆腐");
		if (dao.update(upRec)) {
			System.out.println("更新成功！");
			List<Gourmet> GourmetList4 = dao.select(upRec);
			for (Gourmet list : GourmetList4) {
				System.out.println("number：" + list.getnumber());
				System.out.println("users_number：" + list.getusers_number());
				System.out.println("name：" + list.getname());
				System.out.println("branch：" + list.getbranch());
				System.out.println("genre：" + list.getgenre());
				System.out.println("reputation：" + list.getreputation());
				System.out.println("favorite：" + list.getfavorite());
				System.out.println("memo：" + list.getmemo());
				System.out.println();
			}
		}
		else {
			System.out.println("更新失敗！");
		}
	}

}
