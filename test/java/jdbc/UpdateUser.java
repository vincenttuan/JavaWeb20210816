package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.commons.codec.binary.Base64;

public class UpdateUser {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
		String username = "root";
		String password = "12345678";
		
		String sql = "Update user set u_password=? where u_id=?";
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			//----------------------------------------------------------
			Base64 base64 = new Base64();
			String pwd = "1234"; 
			String pwd_base64 = base64.encodeAsString(pwd.getBytes());
			System.out.printf("%s 編碼後變成 %s\n", pwd, pwd_base64);
			//----------------------------------------------------------
			pstmt.setString(1, pwd_base64);
			pstmt.setInt(2, 1);
			
			int rowcount = pstmt.executeUpdate(); // 執行 sql 更新語句, 並回傳資料表對此 sql 產生的異動筆數
			System.out.println("異動筆數: " + rowcount);
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
		
	}

}
