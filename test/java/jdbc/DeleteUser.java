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
		
		// �Ч� u_id = 1 ����ƧR��
		String sql = "Delete from user where u_id=?";
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			PreparedStatement pstmt = conn.prepareStatement(sql);) {
			
			int u_id = 1;
			pstmt.setInt(1, u_id);
				
			int rowcount = pstmt.executeUpdate(); // ���� sql ��s�y�y, �æ^�Ǹ�ƪ�惡 sql ���ͪ����ʵ���
			System.out.println("���ʵ���: " + rowcount);
				
		} catch (Exception e) {
				e.printStackTrace(System.out);
		}
	}

}
