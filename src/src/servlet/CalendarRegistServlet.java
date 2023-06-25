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
		//クリックした日付取得
		String date = request.getParameter("date");
		request.setAttribute("date",date);
		System.out.println("date"+date);


		// カレンダー登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar_regist.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// カレンダーの日付に対する予定をDBに登録する

		// セッションスコープに格納してあるユーザー番号を取得する
				request.setCharacterEncoding("UTF-8");
				HttpSession session = request.getSession();
				LoginUser user = (LoginUser)session.getAttribute("number");
				int users_number = user.getNumber();
		// リクエストパラメータを取得する　クライアントがjspで入力した情報を取得
				request.setCharacterEncoding("UTF-8");
				String sDate = request.getParameter("start_date");		//YYYY-MM-DDThh:mm
				sDate = sDate.replace("T", " ");											//Tを消している
				sDate = sDate + ":00";
				Timestamp start_date = Timestamp.valueOf(sDate);
				String eDate = request.getParameter("end_date");		//YYYY-MM-DDThh:mm
				eDate = eDate.replace("T", " ");											//Tを消している
				eDate = eDate + ":00";
				Timestamp end_date = Timestamp.valueOf(eDate);
				String color = request.getParameter("color");
				String memo = request.getParameter("memo");
				String branch = request.getParameter("branch");


				//Calendarテーブルに登録
				Calendar schedule = new Calendar(users_number,start_date,end_date,color,memo,branch);
				CalendarDAO cdao = new CalendarDAO();
				cdao.insert(schedule);
				
				// カレンダーサーブレットにリダイレクトする
				response.sendRedirect("/KSHMY/CalendarServlet");
					
				/*//カレンダーページに フォワードする
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/calendar_regist.jsp");
				dispatcher.forward(request, response);*/

	}

}
