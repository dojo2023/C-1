package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GourmetDAO;
import model.Gourmet;

/**
 * Servlet implementation class GourmetServlet
 */
@WebServlet("/GourmetServlet")
public class GourmetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GourmetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// グルメ一覧/検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet.jsp");
		dispatcher.forward(request, response);
//		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		String keyWord = request.getParameter("keyWord");
//		int favorite = 0;
//		String[] checkedGenre = null;
//
//		//登録する内容を記述
////		String name  = "とんこつ";
////		String branch = "株式会社A";
////		String genre = "中華";
////		int reputation = 4;
////		int favorite  = 1;
////		String memo = "おいしかった。";
//
//		// 登録処理を行う
//			GourmetDAO gDAO = new GourmetDAO();
//
//		//Gourmet gourmet = new Gourmet(0,0,name,branch,genre,reputation,favorite,memo);
//
//		List<Gourmet> gourmetList = gDAO.select(keyWord,favorite,checkedGenre);
//		request.setAttribute("cardList", gourmetList);
//
//		// 登録内容をリクエストスコープに格納する
//		request.setAttribute("GOURMETLIST", gourmetList);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();



		request.setCharacterEncoding("UTF-8");
		String number_str = request.getParameter("number");
		int number = Integer.valueOf(number_str);
		String users_number_str = request.getParameter("users_number");
		int users_number = Integer.valueOf(users_number_str);
		String name = request.getParameter("name");
		String branch = request.getParameter("branch");
		String genre = request.getParameter("genre");
		String favorite_str = request.getParameter("favorite");
		int favorite = Integer.valueOf(favorite_str);
		String reputation_str = request.getParameter("reputation");
		int reputation = Integer.valueOf(reputation_str);
		String memo = request.getParameter("memo");

		//登録処理を行う
		GourmetDAO gDao = new GourmetDAO();
		gDao.insert_store(new Gourmet(number, users_number, name, branch, genre, favorite, reputation, memo));	// 登録成功

		// 一覧ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet.jsp");
		dispatcher.forward(request, response);
	}

}
