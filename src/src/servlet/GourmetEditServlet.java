package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GourmetDAO;
import model.Gourmet;
import model.LoginUser;

/**
 * Servlet implementation class GourmetEditServlet
 */
@WebServlet("/GourmetEditServlet")
public class GourmetEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GourmetEditServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//	リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		// セッションスコープにユーザのNumberを格納する
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("number");
		int users_number = user.getNumber();
		String store_number_str =  request.getParameter("number");
		int store_number = Integer.valueOf(store_number_str);


		//編集したいレコードを選択・表示
		GourmetDAO GDAO= new GourmetDAO();
		Gourmet gourmet = new Gourmet();
		//store.numberを持ってこないと実行できない
		gourmet.setStore_number(store_number);
		gourmet.setUsers_number(users_number);

		System.out.println(store_number);
		System.out.println(users_number);

		Gourmet gourmetRecord= GDAO.select_record(gourmet);
		if (gourmetRecord!=null) {
			System.out.println("成功");
		}else{
			System.out.println("残念");
		}

		request.setAttribute("gourmetRecord", gourmetRecord);


		// グルメ編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet_edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//	リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		// セッションスコープにユーザのNumberを格納する
		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("number");
		int users_number = user.getNumber();
		String name = request.getParameter("name");
		String branch = request.getParameter("branch");
		String genre = request.getParameter("genre");
		String reputation_str =  request.getParameter("reputation");
		int reputation = Integer.valueOf(reputation_str);
		String favorite_str =  request.getParameter("favorite");
		int favorite = Integer.valueOf(favorite_str);
		String memo = request.getParameter("memo");

		//登録処理を行う（storeテーブルに登録）
		Gourmet list1 = new Gourmet(name, branch, genre);
		GourmetDAO gDao = new GourmetDAO();
		int autoIncrementKey = gDao.insert_store(list1);


		//登録処理を行う（reputationテーブルに登録）
		Gourmet list2 = new Gourmet(autoIncrementKey, users_number, reputation, favorite, memo);

		gDao.insert_reputation(list2);


		//グルメリストの表示を行う
		GourmetDAO GDAO= new GourmetDAO();
		Gourmet gourmet = new Gourmet();
		gourmet.setUsers_number(users_number);
		List<Gourmet> gourmetList= GDAO.select_GourmetList(gourmet);
		request.setAttribute("gourmetList", gourmetList);

		// 一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet.jsp");
		dispatcher.forward(request, response);
	}
}