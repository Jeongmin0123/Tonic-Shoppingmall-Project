package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드

public class MemberDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insertM = "INSERT INTO member VALUES(, ?, ?, ?, ?, ?, ?, ?)";
	String sql_selectOne = "SELECT * FROM member WHERE id=?";
	String sql_findIDbyTel = "SELECT id FROM member WHERE tel=?";
	String sql_deleteM = "DELETE FROM member WHERE id=?";
//	String sql_deleteL = "DELETE FROM member WHERE id=? AND pw=?";
	
	public boolean insert(MemberVO member) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertM);
			// pstmt.setString(1, member.getMno()); 시퀀스로 변경예정
		    pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMgender());
			pstmt.setInt(3, member.getMbirth());
			pstmt.setString(4, member.getMaddr());
			pstmt.setString(5, member.getMtel());
			pstmt.setString(6, member.getMemail());
			pstmt.setString(7, member.getId());
			pstmt.executeUpdate(); // 영향을 받은 행수 반환 메서드
		} catch (SQLException e) {
			System.out.println("MemberDAO insert() 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}
	
	public boolean selectOne(MemberVO member) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("존재하는 ID입니다.");
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO selectOne() 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return false;
	}
	
//  findIDbyTel, 전화번호로 ID 찾기
	public String findIDbyTel(String tel) {
		con = JDBCUtil.connect();
		String id = null;
		
		try {
			pstmt = con.prepareStatement(sql_findIDbyTel);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getString("id");
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		
		return id;
	}
	
//  delete(ID)
	public boolean delete(String id) {
		con = JDBCUtil.connect();
		boolean result = false;
		
		try { 
			pstmt = con.prepareStatement(sql_deleteM);
			pstmt.setString(1, id);
		//	pstmt.setString(2, pw);
			result = 1 == pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result;
	}
}