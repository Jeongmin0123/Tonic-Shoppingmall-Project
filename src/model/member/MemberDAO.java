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
	
	public boolean selectOne(MemberVO member) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setString(1, member.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("해당하는 id 존재");
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
	
}