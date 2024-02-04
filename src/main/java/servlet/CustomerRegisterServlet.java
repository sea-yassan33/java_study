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
import dao.RegisterCustomer;
import dto.Admin;
import dto.Customer;

/**
 * Servlet implementation class CustomerRegisterServlet
 */
@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// get
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/customer_register.jsp");
		dispatcher.forward(request, response);
	}

	//post
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コードの設定
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		// 顧客登録画面で入力された値を取得
		String cusName = request.getParameter("customer_name");
		String cusAddress = request.getParameter("customer_address");
		
		// 管理者セッションを取得
		HttpSession session = request.getSession(true);
		Admin admin = (Admin) session.getAttribute("admin");
		
		RegisterCustomer register = new RegisterCustomer();
		
		// 顧客情報登録処理を実施
		register.customerRegister(admin.getId(), cusName, cusAddress);
		
		Login login = new Login();
		List<Customer> customers = null;
		
		//dbから取得した顧客情報を格納
		customers = login.getCustomerInfo(String.valueOf(admin.getId()));
		
		// 格納した顧客情報を遷移先の画面に渡す
		request.setAttribute("customer", customers);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/customer_list.jsp");
		dispatcher.forward(request, response);
		
	}

}
