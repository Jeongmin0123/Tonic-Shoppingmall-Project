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
	String sql_checkID = "SELECT * FROM loginfo WHERE id=?";
	String sql_insertL = "INSERT INTO loginfo VALUES(?, ?, ?)";
	String sql_isExistID = "SELECT * FROM loginfo WHERE id=?";
	String sql_deleteL = "DELETE FROM loginfo WHERE id=? AND pw=?";
	
	public boolean checkID(LogInfoVO log) {
	//  로그인 성공여부를 반환하는 메서드
		con = JDBCUtil.connect(); // Connection 타입
		try {
			pstmt = con.prepareStatement(sql_checkID);
			pstmt.setString(1, log.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("이미 존재하는 ID입니다.");
				if(rs.getString("pw").equals(log.getPw())) {
					System.out.println("성공");
					return true;
				}
			}
		} catch(SQLException e) {
			System.out.println("LogInfoDAO checkID() 문제발생");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con); 
		}
		return false;
	}
	
	public boolean insert(LogInfoVO log) {
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
	
//  isExistID, 해당 ID가 존재하는가 == 중복확인 구현
	public boolean isExistID(String id) {
		con = JDBCUtil.connect();
		boolean result = false;
		try {
			pstmt = con.prepareStatement(sql_isExistID);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			result = rs.next(); 
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result;
	}
	
//  delete(ID, PW)
	public boolean delete(String id, String pw) {
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
