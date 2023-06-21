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
import model.Calendar;
import model.LoginUser;

/**
 * Servlet implementation class CalendarServlet
 */
@WebServlet("/CalendarServlet")
public class CalendarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// もしもログインしていなかったらログインサーブレットにリダイレクトする
//		HttpSession session = request.getSession();
//		if (session.getAttribute("id") == null) {
//			response.sendRedirect("/KSHMY/LoginServlet");
//			return;
//		}
//		//DOGETはフォワードするだけ
//		// カレンダーページにフォワードする
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
//		dispatcher.forward(request, response);
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションスコープに保存されているuser_numberを取り出したい
		HttpSession session = request.getSession();

		LoginUser user = (LoginUser)session.getAttribute("number");

		// ユーザー番号からユーザーが登録している予定の一覧を検索する
		CalendarDAO cldDao = new CalendarDAO();
		List<Calendar> cardlist = cldDao.userselect(user);

		// 検索結果をリクエストスコープに格納する
		request.setAttribute("cardlist",cardlist);


		// カレンダーページにフォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
				dispatcher.forward(request, response);

	}
}
