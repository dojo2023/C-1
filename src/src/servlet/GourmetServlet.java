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


		LoginUser user = (LoginUser)session.getAttribute("number");
		int users_number = user.getNumber();

		//グルメリストの表示を行う
		GourmetDAO GDAO= new GourmetDAO();
		Gourmet gourmet = new Gourmet();
		gourmet.setUsers_number(users_number);
		List<Gourmet> gourmetList= GDAO.select_GourmetList(gourmet);
		request.setAttribute("gourmetList", gourmetList);

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
//		リクエストパラメータを取得する
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
			
			//更新処理を行う（storeテーブルに登録）
			Gourmet list1 = new Gourmet(name, branch, genre);
			GourmetDAO gDao = new GourmetDAO();
			int autoIncrementKey = gDao.insert_store(list1);


			//更新処理を行う（reputationテーブルに登録）
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
