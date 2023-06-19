package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.LoginUser;
import model.Users;

/**
 * Servlet implementation class UserEditServlet
 */
@WebServlet("/UserEditServlet")
public class UserEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザ情報編集ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_edit.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザー情報をDBに保存

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String workspace = request.getParameter("workspace");
		String prefecture_number_str = request.getParameter("prefecture_number");
		int prefecture_number = Integer.valueOf(prefecture_number_str);
		String user_id = request.getParameter("user_id");
		String address = request.getParameter("user_pw");
		String first = request.getParameter("first");
		String secound = request.getParameter("secound");
		String third = request.getParameter("third");

		//user情報更新
		UsersDAO udao = new UsersDAO();

		LoginUser user = new LoginUser(1);

		if (request.getParameter("submit").equals("保存")) {
			if (udao.update (new Users(name,workspace,prefecture_number,user_id,address,first,secound,third), user));
		}

		// メインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
