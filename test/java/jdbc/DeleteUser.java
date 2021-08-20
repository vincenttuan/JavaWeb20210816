package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteUser {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
		String username = "root";
		String password = "12345678";
		
		// 請把 u_id = 1 的資料刪除
		String sql = "Delete from user where u_id=?";
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			int u_id = 1;
			pstmt.setInt(1, u_id);
				
			int rowcount = pstmt.executeUpdate(); // 執行 sql 更新語句, 並回傳資料表對此 sql 產生的異動筆數
			System.out.println("異動筆數: " + rowcount);
				
		} catch (Exception e) {
				e.printStackTrace(System.out);
		}
	}

}
