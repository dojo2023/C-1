package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.LoginUser;
import model.Users;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ログインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
//		String idnumber= request.getParameter("number");
//		int number = Integer.valueOf(idnumber);

		// ログイン処理を
		UsersDAO uDao = new UsersDAO();
		//if( true or false){}
		//if( int )
		//int result = uDao.idCheck();
		//if( result > 0){}
		int idNumber = uDao.idCheck(new Users(null, null, 0, id, pw, null, null, null));
		if (idNumber > 0 ) {	// ログイン成功
			// セッションスコープにNumberを格納する
			HttpSession session = request.getSession();
			session.setAttribute("number", new LoginUser(idNumber));    //setAtributeはスコープでデータを設定する際のメソッド

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/KSHMY/MainServlet");
		}
		else {									// ログイン失敗
			response.sendRedirect("/KSHMY/LoginServlet");
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//		// メインサーブレットにリダイレクトする
		//		response.sendRedirect("/KSHMY/MainServlet");
		//	}

	}
}
