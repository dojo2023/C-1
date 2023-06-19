package servlet;

import java.io.IOException;
import java.sql.Timestamp;
//import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Calendar;
/**
 * Servlet implementation class CalendarEditServlet
 */
@WebServlet("/CalendarEditServlet")
public class CalendarEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalendarEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 登録する内容
		Timestamp start_date = new Timestamp (System.currentTimeMillis());
		Timestamp end_date = new Timestamp (System.currentTimeMillis());
		String color = "赤";
		String memo = "発表会";

		// 登録内容をリクエストスコープに格納する
		Calendar calendar = new Calendar(0,start_date, end_date, color, memo, null);
		request.setAttribute("Calendar", calendar);


		//カレンダー編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar_edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		// フォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
			dispatcher.forward(request, response);

	}
}
