package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCUtil {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "user"; // 제 계정은 user입니다. 사용자마다 다른데 어떻게 처리해야 될 지.
	static String password = "1234";
	
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결에 실패하였습니다.");
		}
		return con;
	}
	
	public static void disconnect(PreparedStatement pstmt, Connection con) {
		try {
			pstmt.close();
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("데이터베이스 연결 해제에 실패하였습니다.");
		}
	}
}
