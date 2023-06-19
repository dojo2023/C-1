package test;

import java.util.List;

import dao.CalendarDAO;
import model.Calendar;
import model.CalendarDate;
import model.LoginUser;

public class CalendarDAOTest {

	public static void main(String[] args) {

		CalendarDAO cdao = new CalendarDAO();

		LoginUser user = new LoginUser(1);
		// userselect()のテスト
		System.out.println("---------- userselect()のテスト ----------");
		List<Calendar> cardList2 = cdao.userselect(user);  //Calendarの持つselectメソッドを読みだす
		for (Calendar list : cardList2) {    //データ型：コレクション
			System.out.println("USERS_NUMBER：" + list.getUsers_number());
			System.out.println("START_DATE：" + list.getStart_date());
			System.out.println("END_DATE：" + list.getEnd_date());
			System.out.println("COLOR：" + list.getColor());
			System.out.println("MEMO：" + list.getMemo());
			System.out.println("BRANCH：" + list.getBranch());

			System.out.println();
		}

		CalendarDate date = new CalendarDate();

		// dayselect()のテスト
		System.out.println("---------- dayselect()のテスト ----------");
		List<Calendar> cardList3 = cdao.dayselect(user,date);  //Calendarの持つselectメソッドを読みだす
		for (Calendar list : cardList3) {    //データ型：コレクション
			System.out.println("USERS_NUMBER：" + list.getUsers_number());
			System.out.println("START_DATE：" + list.getStart_date());
			System.out.println("END_DATE：" + list.getEnd_date());
			System.out.println("COLOR：" + list.getColor());
			System.out.println("MEMO：" + list.getMemo());
			System.out.println("BRANCH：" + list.getBranch());

			System.out.println();
		}
		// editselect()のテスト
//		System.out.println("---------- userselect()のテスト ----------");
//		Calendar store = new Calendar();
//		List<Calendar> cardList4 = cdao.editselect(user, store);  //Calendarの持つselectメソッドを読みだす
//		for (Calendar list : cardList4) {    //データ型：コレクション
//			System.out.println("USERS_NUMBER：" + list.getUsers_number());
//			System.out.println("START_DATE：" + list.getStart_date());
//			System.out.println("END_DATE：" + list.getEnd_date());
//			System.out.println("COLOR：" + list.getColor());
//			System.out.println("MEMO：" + list.getMemo());
//			System.out.println("BRANCH：" + list.getBranch());
//
//			System.out.println();
//		}


	}
}
