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

import control.Login;
import dto.Admin;
import dto.Customer;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//ログイン画面の表示
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コードの設定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// ログイン画面で入力された値を取得
		String admin_id = request.getParameter("admin_id");
		String password = request.getParameter("password");
		
		//入力値を元にdbから値を取得
		Login login = new Login();
		Admin admin = login.chaeck(admin_id, password);
		
		if(admin.isLogin_flag()) {
			//ログイン成功
			System.out.println("ログイン成功");
			
			//ログイン成功時のセッションオブジェクト作成
			HttpSession adminSession = request.getSession(true);
			adminSession.setAttribute("admin", admin);
			
			List<Customer> customer = null;
			// dbから取得した顧客情報を格納
			customer = login.getCustomerInfo(admin_id);
			
			// 顧客情報を遷移先の画面に渡す
			request.setAttribute("customer", customer);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/customer_list.jsp");
			dispatcher.forward(request, response);
		}else {
			//ログイン失敗
			System.out.println("ログイン失敗");
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
		}
	}

}
