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
			
			pstmt.setString(1, "John"); // sql �r��� 1 �Ӱݸ��� "John"
			
			String pwd = "1234"; // �n�]�w���K�X
			Base64 base64 = new Base64(); // �إ� base64 ����
			String pwd_base64 = base64.encodeToString(pwd.getBytes()); // �N pwd �i�� base64 �s�X
			
			pstmt.setString(2, pwd_base64);
			pstmt.setInt(3, 1);
			
			int rowcount = pstmt.executeUpdate(); // ���� sql ��s�y�y, �æ^�Ǹ�ƪ�惡 sql ���ͪ����ʵ���
			System.out.println("���ʵ���: " + rowcount);
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
		}
	}

}
