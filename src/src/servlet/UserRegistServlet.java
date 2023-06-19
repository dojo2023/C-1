package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.Users;
/**
 * Servlet implementation class UserRegistServlet
 */
@WebServlet("/UserRegistServlet")
public class UserRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Userテーブルから今まで登録された所属地の一覧を持ってくる（プルダウンメニューに使用）
		UsersDAO uDAO = new UsersDAO();	
		List<String> workspace= uDAO. select_workspace();	
		request.setAttribute("workspace",workspace);	
		
		// ユーザー登録ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/user_regist.jsp");
		dispatcher.forward(request, response);
					
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ユーザー情報をDBに登録
		
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
		
		//Usersテーブルに登録
		Users user = new Users(name,workspace,prefecture_number,user_id,address,first,secound,third);		
		UsersDAO dao = new UsersDAO();
		dao.insert(user);
		
		//ログインページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

}
