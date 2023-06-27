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

import dao.CalendarDAO;
import dao.GourmetDAO;
import dao.UsersDAO;
import model.Gourmet;
import model.LoginUser;
import model.Users;

/**
 * Servlet implementation class GourmetRegistServlet
 */
@WebServlet("/GourmetRegistServlet")
public class GourmetRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GourmetRegistServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Gourmetテーブルから今までに登録された所属地の一覧を持ってくる
		CalendarDAO cDAO = new CalendarDAO();
		List<String> branch = cDAO.select_branch();
		request.setAttribute("branch", branch);

		// グルメ登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet_regist.jsp");
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
		UsersDAO uDAO = new UsersDAO();
		Users card = uDAO.select_User(user);


		//登録処理を行う（reputationテーブルに登録）
		Gourmet list2 = new Gourmet(autoIncrementKey, users_number, reputation, favorite, memo);
		gDao.insert_reputation(list2);

		//グルメリストに移動（リダイレクト）
		response.sendRedirect("/KSHMY/GourmetServlet");
	}

}
