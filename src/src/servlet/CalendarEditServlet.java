package servlet;

import java.io.IOException;
import java.sql.Timestamp;
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
		//getはもともとある情報を書く

		// 営業所のデータ
		CalendarDAO cDAO = new CalendarDAO();
		List <String>  branch = cDAO.select_branch();
		request.setAttribute("branch",branch);

		// calendareテーブルから指定した日付の予定を持ってくる
		int number = Integer.parseInt(request.getParameter("number"));
		Calendar calendar = new Calendar();
		calendar =cDAO.editselect(number);
		request.setAttribute("calendar",calendar);


		// 登録する内容
//		Timestamp start_date = new Timestamp (System.currentTimeMillis());
//		Timestamp end_date = new Timestamp (System.currentTimeMillis());
//		String color = "赤";
//		String memo = "発表会";
		// 登録内容をリクエストスコープに格納する
//		Calendar calendar = new Calendar(0,start_date, end_date, color, memo, null);
//		request.setAttribute("Calendar", calendar);

		//カレンダー編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar_edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// postは更新したりする場合に書く

		// リクエストパラメータを取得する
			// 開始日時
			request.setCharacterEncoding("UTF-8");
			String sDate = request.getParameter("start_date");		//YYYY-MM-DDThh:mm
			sDate = sDate.replace("T", " ");											//YYYY-MM-DD hh:mm
			sDate = sDate + ":00";														//YYYY-MM-DD hh:mm:00
			System.out.println(request.getParameter("start_date"));
			System.out.println(sDate);

			// 修了日時
			request.setCharacterEncoding("UTF-8");
			String eDate = request.getParameter("end_date");		//YYYY-MM-DDThh:mm
			eDate = eDate.replace("T", " ");											//YYYY-MM-DD hh:mm
			eDate = eDate + ":00";														//YYYY-MM-DD hh:mm:00
			System.out.println(request.getParameter("end_date"));
			System.out.println(eDate);
			
			String number_str = request.getParameter("number");
			int number = Integer.valueOf(number_str);
			Timestamp start_date = Timestamp.valueOf(sDate);
			Timestamp end_date =Timestamp.valueOf(eDate);
			String color = request.getParameter("color");
			String memo = request.getParameter("memo");
			String branch = request.getParameter("branch");

			// セッションスコープ取得
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser)session.getAttribute("number");
			int users_number = user.getNumber();

		// リクエストスコープに格納してスケジュールを編集（更新）
			Calendar calendar = new Calendar(number,users_number, start_date, end_date, color, memo,branch);
			CalendarDAO schedule = new CalendarDAO();
			schedule.update(calendar);



		// カレンダーページに フォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar.jsp");
			dispatcher.forward(request, response);

	}
}
