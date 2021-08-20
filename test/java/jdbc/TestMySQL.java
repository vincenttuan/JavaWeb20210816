package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class TestMySQL {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
		String username = "root";
		String password = "12345678";
		String sql = "select u_id, u_username, u_password, u_priority, u_createtime from user";
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			System.out.println("連線是否已關閉: " + conn.isClosed());
			
			while(rs.next()) {
				Integer u_id = rs.getInt("u_id");
				String u_username = rs.getString("u_username");
				String u_password = rs.getString("u_password");
				Integer u_priority = rs.getInt("u_priority");
				Date u_createtime = rs.getDate("u_createtime");
				System.out.println(u_id + "," + u_username + ", " + u_password + ", " + u_priority + "," + u_createtime);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		}
		
	}

}
