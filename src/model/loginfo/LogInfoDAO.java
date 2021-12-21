package model.loginfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil;

public class LogInfoDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
//	String sql_select = "SELECT * FROM loginfo WHERE id=? AND pw=?";
	String sql_checkLogin = "SELECT pw FROM loginfo WHERE id=?";
	String sql_insertL = "INSERT INTO loginfo VALUES(?, ?, ?)";
	String sql_isExistID = "SELECT * FROM loginfo WHERE id=?";
	String sql_deleteL = "DELETE FROM loginfo WHERE id=? AND pw=?";
	
	public boolean checkLogin(String id, String pw) {
	//  로그인 성공여부를 반환하는 메서드
		String LogInfopw = null; // loginfo 테이블의 pw를 넣을 변수
		
		con = JDBCUtil.connect(); // Connection 타입
		try {
			pstmt = con.prepareStatement(sql_checkLogin);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				LogInfopw = rs.getString("pw");
				if(rs.getString("pw").equals(pw)) {
					System.out.println("로그인 성공");
					return true;
				} else { // 비밀번호가 다를 때
					System.out.println("비밀번호가 일치하지 않습니다.");
					return false;
				}
			} else { // 비밀번호가 없을 때
				return false; 
			}
		} catch(SQLException e) {
			System.out.println("LogInfoDAO checkLogin() 문제발생");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con); 
		} 
	}
//  삭제 고려 중
	public boolean insertLogInfo(LogInfoVO log) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertL);
			pstmt.setString(1, log.getLog_code()); // ID, PW만 넣을지 이것도 넣을지.
			pstmt.setString(2, log.getId());
			pstmt.setString(3, log.getPw());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("LogInfoDAO insert() 문제발생");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}
	
//  isExistID, 해당 ID가 존재하는가 
	public boolean isExistID(String id) {
		boolean result = false;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_isExistID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			result = rs.next(); 
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result;
	}
	
//  delete(ID, PW)
	public boolean deleteLogInfo(String id, String pw) {
		con = JDBCUtil.connect();
		boolean result = false;
		
		try { 
			pstmt = con.prepareStatement(sql_deleteL);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			result = 1 == pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result;
	}	
}
