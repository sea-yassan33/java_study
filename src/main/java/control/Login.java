package control;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBconfig;
import dto.Admin;
import dto.Customer;

public class Login {
	
	public Admin chaeck(String admin_id, String password) throws FileNotFoundException{
		
		DBconfig dbInfo = new DBconfig();
		
		//SQL文
		String login_sql = "select * from admin_tb " + "where admin_id = ? and password = ?;";
		
		//管理者オブジェクト作成
		Admin admin = new Admin();
		
		//db接続
		try {
			// データベースへ接続
			Connection conn = dbInfo.connectionSet();
			//変数loguin_sqlの？に引数をセット
			PreparedStatement stmt = conn.prepareStatement(login_sql);
			stmt.setString(1, admin_id);
			stmt.setString(2, password);
			
			//SQL実行し、結果を取得
			ResultSet rs = stmt.executeQuery();
			
			//dbから取得した値をAdminオブジェクトに格納
			//値がなければ、login_flag(false)
			if(rs.next()) {
				admin.setId(rs.getInt("admin_id"));
				admin.setName(rs.getString("name"));
				admin.setPassword(rs.getString("password"));
				admin.setLogin_flag(true);
			}else {
				admin.setLogin_flag(false);
			}
			
		}catch (SQLException e) {
			System.out.println("dbとの接続を閉じます");
			e.printStackTrace();
		}
		
		//dbから取得した値を返す。
		return admin;
	}
	
	/*
	 * 顧客情報の取得
	 */
	public List<Customer> getCustomerInfo(String admin_id) throws FileNotFoundException{
		
		DBconfig dbInfo = new DBconfig();
		
		//SQL文
		String customerSql = "select * from customer_tb where admin_id = ?;";
		
		//顧客情報を格納するList
		List<Customer> cusList = new ArrayList<Customer>();
		
		try {
			// データベースへ接続
			Connection conn = dbInfo.connectionSet();
			//変数loguin_sqlの？に引数をセット
			PreparedStatement stmt = conn.prepareStatement(customerSql);
			stmt.setString(1, admin_id);
			
			//SQL実行
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				// 顧客情報用のオブジェクトを作成
				Customer cusInfo = new Customer();
				// 顧客情報を一件ずつcusListに格納
				cusInfo.setCustomer_id(rs.getInt("customer_id"));
				cusInfo.setAdmin_id(rs.getInt("admin_id"));
				cusInfo.setName(rs.getString("name"));
				cusInfo.setAddress(rs.getString("address"));
				cusInfo.setRegistered_time(rs.getDate("registered_time"));
				cusInfo.setUpdated_time(rs.getDate("updated_time"));
				cusList.add(cusInfo);
			}
		} catch (SQLException e) {
			System.out.println("dbとの接続を閉じます");
			e.printStackTrace();
		}
		return cusList;
	}

}
