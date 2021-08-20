package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.simpleflatmapper.jdbc.JdbcMapper;
import org.simpleflatmapper.jdbc.JdbcMapperFactory;

public class ReadUser3 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
		String username = "root";
		String password = "12345678";
		String sql = "select u_id, u_username, u_password, u_priority, u_createtime from user";
		
		List<User> users = new ArrayList<>();
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			System.out.println("連線是否已關閉: " + conn.isClosed());
			
			JdbcMapper<User[]> mapper = JdbcMapperFactory.newInstance().newMapper(User[].class);
			mapper.stream(rs).forEach(user_array -> users.addAll(Arrays.asList(user_array)));
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		}
		
		// 使用 users
		System.out.println(users.size());
		System.out.println(users);
		
	}

}
