package test;

import dao.UsersDAO;
import model.LoginUser;
import model.Users;


public class UsersDAOTest {
	public static void main(String[] args) {
		UsersDAO dao = new UsersDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		 LoginUser number = new LoginUser(1);
		Users cardList2 = dao.select(number);

			System.out.println("NAME：" + cardList2.getName());
			System.out.println("WORKSPACE：" + cardList2.getWorkspace());
			System.out.println("PREFECTURE_NUMBER：" + cardList2.getPrefecture_number());
			System.out.println("USER_ID：" + cardList2.getUser_id());
			System.out.println("USER_PW：" + cardList2.getUser_pw());
			System.out.println("FIRST：" + cardList2.getFirst());
			System.out.println("SECOND：" + cardList2.getSecond());
			System.out.println("THIRD：" + cardList2.getThird());
			System.out.println();



		// insert()のテスト
		System.out.println("---------- insert()のテスト ----------");
		Users insRec = new Users("山田太郎", "ポケット", 6, "id6", "pw6", "中華", "洋食", "和食");
		 if (dao.insert(insRec)) {
			System.out.println("登録成功！");
			Users cardList3 = dao.select(number);
				System.out.println("NAME：" + cardList3.getName());
				System.out.println("WORKSPACE：" + cardList3.getWorkspace());
				System.out.println("PREFECTURE_NUMBER：" + cardList3.getPrefecture_number());
				System.out.println("USER_ID：" + cardList3.getUser_id());
				System.out.println("USER_PW：" + cardList3.getUser_pw());
				System.out.println("FIRST：" + cardList3.getFirst());
				System.out.println("SECOND：" + cardList3.getSecond());
				System.out.println("THIRD：" + cardList3.getThird());
				System.out.println();
		}
		else {
			System.out.println("登録失敗！");
		}

		// update()のテスト
		System.out.println("---------- update()のテスト ----------");
		Users upRec = new Users("山田太郎", "AAA", 3, "id6", "pw6", "和食", "中華", "洋食");
		if (dao.update(upRec,number)) {
			System.out.println("更新成功！");
			Users cardList4 = dao.select(number);
				System.out.println("NAME：" + cardList4.getName());
				System.out.println("WORKSPACE：" + cardList4.getWorkspace());
				System.out.println("PREFECTURE_NUMBER：" + cardList4.getPrefecture_number());
				System.out.println("USER_ID：" + cardList4.getUser_id());
				System.out.println("USER_PW：" + cardList4.getUser_pw());
				System.out.println("FIRST：" + cardList4.getFirst());
				System.out.println("SECOND：" + cardList4.getSecond());
				System.out.println("THIRD：" + cardList4.getThird());
				System.out.println();

		}
		else {
			System.out.println("更新失敗！");
		}

	}


}
