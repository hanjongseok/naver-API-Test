package db;

import java.sql.*;

public class DB {
//
	public static Connection conn() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(DBconfig.DB_URL, DBconfig.DB_USER, DBconfig.DB_PW);
		System.out.println("연결 성공");
		return conn;
	}
	
}
