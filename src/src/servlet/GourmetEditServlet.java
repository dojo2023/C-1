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
import dao.UsersDAO;
import model.Gourmet;
import model.LoginUser;
import model.Users;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//	リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");

		// セッションスコープにユーザのNumberを格納する
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("number");
		int users_number = user.getNumber();
		String store_number_str =  request.getParameter("store_number");
		int store_number = Integer.valueOf(store_number_str);
		String reputation_str =  request.getParameter("reputation");
		int reputation = Integer.valueOf(reputation_str);
		String favorite_str =  request.getParameter("favorite");
		int favorite = Integer.valueOf(favorite_str);
		String memo = request.getParameter("memo");

		UsersDAO uDAO = new UsersDAO();
		Users card = uDAO.select_User(user);


		//更新処理を行う
		GourmetDAO gDAO= new GourmetDAO();

		Gourmet list = new Gourmet(reputation,favorite,memo);

		//store.numberを持ってこないと実行できない
		list.setStore_number(store_number);
		list.setUsers_number(users_number);
		list.setNumber(store_number);

		System.out.println(store_number);
		System.out.println(users_number);

//		SELECT文を用意し編集したいレコードを持ってくる
		Gourmet gourmetRecord= gDAO.select_record(list);
		if (gourmetRecord.getUsers_number()!=0) {
			gDAO.update_reputation(list);
		}else{
			 gDAO.insert_reputation(list);
		}


		//グルメリストを表示
		GourmetDAO GDAO= new GourmetDAO();
		Gourmet gourmet = new Gourmet();
		gourmet.setUsers_number(users_number);
		List<Gourmet> gourmetList= GDAO.select_GourmetList(gourmet,card);
		request.setAttribute("gourmetList", gourmetList);


		// グルメページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet.jsp");
		dispatcher.forward(request, response);

	}

}