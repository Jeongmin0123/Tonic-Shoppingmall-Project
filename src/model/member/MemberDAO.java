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
	
	String sql_insert = "INSERT INTO member VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
	String sql_checkId = "SELECT * FROM member WHERE id=?";
	
	public boolean insert(MemberVO mem) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insert);
			pstmt.setString(1, mem.getMno());
		    pstmt.setString(2, mem.getMname());
			pstmt.setString(3, mem.getMgender());
			pstmt.setInt(4, mem.getMbirth());
			pstmt.setString(5, mem.getMaddr());
			pstmt.setString(6, mem.getMtel());
			pstmt.setString(7, mem.getMemail());
			pstmt.setString(8, mem.getId());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("MemberDAO insert() 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}
	
	public boolean checkId(MemberVO mem) {
		// 로그인 성공여부를 반환하는 메서드
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_checkId);
			pstmt.setString(1, mem.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("이미 존재하는 ID입니다.");
			}
		} catch(SQLException e) {
			System.out.println("MemberDAO sql_checkId() 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return false;
	}
}
