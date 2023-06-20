package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CalendarDAO;
import model.Calendar;

/**
 * Servlet implementation class CalendarRegistServlet
 */
@WebServlet("/CalendarRegistServlet")
public class CalendarRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//Calendarテーブルに現在までに登録された営業所の一覧を持ってくる
		CalendarDAO cDAO = new CalendarDAO();
		List<String> branch = cDAO.select_branch();
		request.setAttribute("branch",branch);



		// カレンダー登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// カレンダーの日付に対する予定をDBに登録する

		// リクエストパラメータを取得する
				request.setCharacterEncoding("UTF-8");
				String branch = request.getParameter("branch");
				String prefecture_number_str = request.getParameter("prefecture_number");
				int prefecture_number = Integer.valueOf(prefecture_number_str);
				String  = request.getParameter("memo");
				String color = request.getParameter("color");
				String memo = request.getParameter("memo");


				//Calendarテーブルに登録
				Calendar schedule = new Calendar(branch,prefecture_number,,color,memo);
				CalendarDAO dao = new CalendarDAO();
				dao.insert(schedule);

		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
