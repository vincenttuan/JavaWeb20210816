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

public class ReadUser4 {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbcUrl = "jdbc:mysql://localhost:3306/web?serverTimezone=UTC&characterEncoding=utf-8&useUnicode=true";
		String username = "root";
		String password = "12345678";
		String sql = "select u_id, u_username, u_password, u_priority, u_createtime from user where u_id=2";
		
		User user = null;
		
		try(Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			System.out.println("連線是否已關閉: " + conn.isClosed());
			
			// 利用 simpleflatmapper 進行 OR-Mapping
			// 單筆資料
			JdbcMapper<User> mapper = JdbcMapperFactory.newInstance().newMapper(User.class);
			user = mapper.iterator(rs).next();
			
		} catch (Exception e) {
			
			e.printStackTrace(System.out);
			
		}
		
		// 使用 user
		System.out.println(user);
		
	}

}
