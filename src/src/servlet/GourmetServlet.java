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

import dao.GourmetDAO;
import dao.UsersDAO;
import model.Gourmet;
import model.LoginUser;
import model.Users;

/**
 * Servlet implementation class GourmetServlet
 */
@WebServlet("/GourmetServlet")
public class GourmetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GourmetServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		LoginUser user = (LoginUser)session.getAttribute("number");
		int users_number = user.getNumber();
		UsersDAO uDAO = new UsersDAO();
		Users card = uDAO.select_User(user);
		
		//デフォルト
		String kind = "ジャンル";
		String order = "降順";
		String genre[] = {"和食","洋食","中華","その他"};
		int favorite = 2;
		String keyword = "";
		
		request.setAttribute("kind", kind);
		request.setAttribute("order", order);
		request.setAttribute("genre", genre);
		request.setAttribute("favorite", favorite);
		request.setAttribute("keyword", keyword);

		//グルメリストの表示を行う
		GourmetDAO GDAO= new GourmetDAO();
		Gourmet gourmet = new Gourmet();
		gourmet.setUsers_number(users_number);
		List<Gourmet> gourmetList= GDAO.select_GourmetList(gourmet,card,kind,order,genre,favorite,keyword);
		request.setAttribute("gourmetList", gourmetList);

		boolean[] genre_disp = {true, true, true, true};
		request.setAttribute("genre", genre_disp);
		
		// グルメ一覧/検索ページにフォワードする
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet.jsp");
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			HttpSession session = request.getSession();
			LoginUser user = (LoginUser)session.getAttribute("number");
			int users_number = user.getNumber();
			UsersDAO uDAO = new UsersDAO();
			Users card = uDAO.select_User(user);
			
			//リクエストパラメータを取得する
			request.setCharacterEncoding("UTF-8");
			String kind = request.getParameter("kind");
			String order = request.getParameter("order");
			String[] genre = request.getParameterValues("genre");
			int favorite = Integer.valueOf(request.getParameter("favorite"));
			String keyword = request.getParameter("keyword");
			
			if(genre == null) {
				System.out.println("空");
			}
			request.setAttribute("kind", kind);
			request.setAttribute("order", order);
			request.setAttribute("genre", genre);
			request.setAttribute("favorite", favorite);
			request.setAttribute("keyword", keyword);
			
			//グルメリストの表示を行う
			GourmetDAO GDAO= new GourmetDAO();
			Gourmet gourmet = new Gourmet();
			gourmet.setUsers_number(users_number);
			List<Gourmet> gourmetList= GDAO.select_GourmetList(gourmet,card,kind,order,genre,favorite,keyword);
			request.setAttribute("gourmetList", gourmetList);
			
			//どのジャンルが選ばれているかのフラグ
			boolean[] genre_disp = {false, false, false, false};
			for (String item : genre) {//[9]
	            if(item.equals("和食")) {
	            	genre_disp[0] = true;
	            }else if(item.equals("洋食")) {
	            	genre_disp[1] = true;
	            }else if(item.equals("中華")) {
	            	genre_disp[2] = true;
	            }else {
	            	genre_disp[3] = true;
	            }
	        }
			request.setAttribute("genre", genre_disp);
			

			// 一覧ページにフォワードする
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/gourmet.jsp");
			dispatcher.forward(request, response);
		}

}
