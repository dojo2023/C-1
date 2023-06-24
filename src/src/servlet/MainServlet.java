package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CalendarDAO;
import dao.PrefectureDAO;
import dao.UsersDAO;
import model.Calendar;
import model.LoginUser;
import model.Prefecture;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ログイン中ユーザの県番号に応じたprefecture情報を格納
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("number");
		UsersDAO uDAO = new UsersDAO();
		int prefecture_num = uDAO.select_User(user).getPrefecture_number(); //ユーザの所属地の県番号を取得
		PrefectureDAO pDAO = new PrefectureDAO();
		Prefecture prefecture = pDAO.select(prefecture_num);	//ユーザの所属地の県番号に関する緯度経度県名取得
		request.setAttribute("prefecture",prefecture);

		//ログイン中ユーザの本日の予定表示
		Date d = new Date();
        SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd");
        String start = d1.format(d) + " 00:00:00";
        String end = d1.format(d) + " 23:59:59";

		CalendarDAO cDAO = new CalendarDAO();
		List<Calendar> todayList = cDAO.dayselect(user, start,end);
		request.setAttribute("todayList",todayList);

		String test = "2023-06-22 12:01:00.0";
		String test2 = test.substring(11, 16);

		System.out.println(test);
		System.out.println(test2);

		//修造用テキスト
		String allMsg[] = {"崖っぷちありがとう！最高だ！",
				"君が次に叩く1回で、壁は打ち破れるかもしれないんだ！",
				"家族は史上最強の味方だ！",
				"褒め言葉よりも苦言に感謝。",
				"ナイスボレー、修造！",
				"人の弱点を見つける天才よりも、人を褒める天才がいい。",
				"真剣に考えても、深刻になるな！",
				"反省はしろ！後悔はするな！",
				"ネクストタイム！",
				"三日坊主OK！",
				"大丈夫！君は太陽だから！！",
				"これは終わりではなく、新しい修造の始まり。"};
		Random rnd = new Random();
		String msg = allMsg[rnd.nextInt(allMsg.length)];
		request.setAttribute("msg",msg);

		// メインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// フォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet_edit.jsp");
			dispatcher.forward(request, response);

	}
}
