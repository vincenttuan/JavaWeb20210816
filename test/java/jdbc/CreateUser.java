package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.commons.codec.binary.Base64;

public class CreateUser {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
		String username = "root";
		String password = "12345678";
		
		String sql = "Insert into user(u_username, u_password, u_priority) values(?, ?, ?)"; 
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			pstmt.setString(1, "John"); // sql 字串第 1 個問號放 "John"
			
			String pwd = "1234"; // 要設定的密碼
			Base64 base64 = new Base64(); // 建立 base64 物件
			String pwd_base64 = base64.encodeToString(pwd.getBytes()); // 將 pwd 進行 base64 編碼
			
			pstmt.setString(2, pwd_base64);
			pstmt.setInt(3, 1);
			
			int rowcount = pstmt.executeUpdate(); // 執行 sql 更新語句, 並回傳資料表對此 sql 產生的異動筆數
			System.out.println("異動筆數: " + rowcount);
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
