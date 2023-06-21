package servlet;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PrefectureDAO;
import dao.UsersDAO;
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
		
		//修造用テキスト
		String allMsg[] = {"あ","い","う","え"};
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
