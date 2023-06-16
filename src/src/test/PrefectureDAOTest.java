package test;


import dao.PrefectureDAO;
import model.Prefecture;

public class PrefectureDAOTest {
	public static void main(String[] args) {
		PrefectureDAO dao = new PrefectureDAO();

		// select()のテスト
		System.out.println("---------- select()のテスト ----------");
		int param = 1;
		Prefecture cardList2 = dao.select(param);

			System.out.println("NUMBER：" + cardList2.getNumber());
			System.out.println("IDO：" + cardList2.getIdo());
			System.out.println("KEIDO：" +cardList2.getKeido());
			System.out.println("NAME：" +cardList2.getName());
			System.out.println();
		}
	}
