package model.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드

public class EmpDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insert = "INSERT INTO emp VALUES(emp_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	String sql_checkId = "SELECT * FROM emp WHERE id=?";
	
	public boolean insert(EmpVO emp) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insert);
		//  pstmt.setString(1, emp.getEno()); 시퀀스로 변경
		    pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getEgender());
			pstmt.setInt(3, emp.getEbirth());
			pstmt.setString(4, emp.getEaddr());
			pstmt.setString(5, emp.getEtel());
			pstmt.setString(6, emp.getEemail());
			pstmt.setString(7, emp.getId());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("EmpDAO insert() 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}
	
	public boolean checkId(EmpVO emp) {
//      로그인 성공여부를 반환하는 메서드
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_checkId);
			pstmt.setString(1, emp.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("이미 존재하는 ID입니다.");
			}
		} catch(SQLException e) {
			System.out.println("EmpDAO sql_checkId() 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return false;
	}
}
