package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestMySQL {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
		String username = "root";
		String password = "12345678";
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, username, password);) {
			
			System.out.println("連線是否已關閉: " + conn.isClosed());
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		}
		
	}

}
