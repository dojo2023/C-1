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
		//Userテーブルから今まで登録されたユーザー情報を持ってくる
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("number");
		UsersDAO uDAO = new UsersDAO();
		Users card = uDAO.select_User(user);
		request.setAttribute("card",card);

		//Userテーブルから今まで登録された所属地の一覧を持ってくる（プルダウンメニューに使用）
		List<String> workspace= uDAO. select_workspace();
		request.setAttribute("workspace",workspace);


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
		String second = request.getParameter("second");
		String third = request.getParameter("third");

		//ユーザー情報編集（更新）
		UsersDAO udao = new UsersDAO();

		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("number");

		if (request.getParameter("save").equals("保存")) {
			if (udao.update (new Users(name,workspace,prefecture_number,user_id,address,first,second,third), user));
		}

		// メインページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);
	}

}
