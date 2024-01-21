package main;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.DBconfig;
import dto.Admin;

public class Login {
	
	public Admin chaeck(String admin_id, String password) throws FileNotFoundException{
		
		DBconfig dbInfo = new DBconfig();
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = dbInfo.getDBinfo().get("url");
		String user = dbInfo.getDBinfo().get("user");
		String pass = dbInfo.getDBinfo().get("password");
		
		//実行SQL
		String login_sql = "select * from admin_tb " + "where admin_id = ? and password = ?;";
		
		//管理者オブジェクト作成
		Admin admin = new Admin();
		
		//db接続
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url,user,pass);
			PreparedStatement stmt = conn.prepareStatement(login_sql);
			
			//変数loguin_sqlの？に引数の
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
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバのロードでエラーが発生しました");
		} catch (SQLException e) {
			System.out.println("dbとの接続を閉じます");
			e.printStackTrace();
		}
		
		//dbから取得した値を返す。
		return admin;
	}

}
