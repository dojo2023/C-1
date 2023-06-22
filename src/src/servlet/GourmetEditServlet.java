package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.GourmetDAO;
import model.Gourmet;
import model.LoginUser;

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

		//編集したいレコードを選択・表示
		GourmetDAO GDAO= new GourmetDAO();
		Gourmet gourmet = new Gourmet();
		gourmet.setUsers_number(users_number);
		Gourmet gourmetRecord= GDAO.select_record(gourmet);
		request.setAttribute("gourmetRecord", gourmetRecord);

		// グルメ編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet_edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// reputationDBを更新する

		//グルメページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet.jsp");
		dispatcher.forward(request, response);
	}

}
