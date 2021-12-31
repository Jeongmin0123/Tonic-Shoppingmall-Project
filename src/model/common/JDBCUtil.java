package model.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	static String driver = "oracle.jdbc.driver.OracleDriver";
	static String url = "jdbc:oracle:thin:@localhost:1521:xe";
	static String user = "user"; // 제 컴퓨터 ID는 user입니다.
	static String password = "1234";
	
	public static Connection connect() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println("데이터베이스 연결에 실패하였습니다.");
			e.printStackTrace();
		}
		return con;
	}
	
	public static void disconnect(PreparedStatement pstmt, Connection con) {
		try {
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 해제에 실패하였습니다.");
			e.printStackTrace();
		}
	}
//  disconnect 오버로딩 추가
	public static void disconnect(ResultSet rs, PreparedStatement pstmt, Connection con) {
		try {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (con != null) con.close();
		} catch (SQLException e) {
			System.out.println("데이터베이스 연결 해제에 실패하였습니다.");
			e.printStackTrace();
		}
	}
}
