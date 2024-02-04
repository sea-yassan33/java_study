package dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import config.DBconfig;

public class RegisterCustomer {
	
	public void customerRegister(int adminId, String name, String address) throws FileNotFoundException{
		
		DBconfig dbInfo = new DBconfig();
		
		// SQL文
		String registerSql = "insert into customer_tb(admin_id, name, address) values(?,?,?)";
		
		//db接続
		try {
			// dbへ接続
			Connection conn = dbInfo.connectionSet();
			// オートコミット機能を無効化
			conn.setAutoCommit(false);
			
			try {
				// 変数loguinSqlの?に引数をセット
				PreparedStatement stmt = conn.prepareStatement(registerSql);
				stmt.setInt(1, adminId);
				stmt.setString(2, name);
				stmt.setString(3, address);
				// SQL実行
				stmt.executeUpdate();
				
				// コミット
				conn.commit();
				System.out.println("コミット処理を行いました");
			} catch (SQLException e) {
				conn.rollback();
				System.out.println("ロールバック処理を行いました");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("dbとの接続を閉じます");
			e.printStackTrace();
		}
	}
}
