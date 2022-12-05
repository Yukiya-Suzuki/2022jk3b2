package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
	final String url = "jdbc:mysql://192.168.54.225:3306/team_b_db";
	final String user = "userb";
	final String pass = "passwordb";
	
	public Connection conn() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, user, pass);
		} catch(Exception e) {
			e.printStackTrace();
			con = null;
		}
		return con;
	}
	
	
}
