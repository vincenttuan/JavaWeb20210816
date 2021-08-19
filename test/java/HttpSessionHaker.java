import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class HttpSessionHaker {
	public static void main(String[] args) throws Exception {
		
		String path = "http://localhost:8080/JavaWeb20210816/form/session_form.jsp";
		URL url = new URL(path);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		// ¶ë¤J¤@­Ó header
		connection.setRequestProperty("cookie", "JSESSIONID=71FDF203EA5556A3C97F17F46D90BB9B");
		connection.connect();
		InputStream is = connection.getInputStream();
		System.out.println(IOUtils.toString(is,"utf-8"));
		
	}
}
