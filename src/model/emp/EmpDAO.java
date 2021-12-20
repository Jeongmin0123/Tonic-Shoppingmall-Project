package model.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드
import model.member.MemberVO;

public class EmpDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insertE = "INSERT INTO emp VALUES('EMP' || emp_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	String sql_selectE = "SELECT * FROM emp WHERE id=?";
	String sql_updateE = "UPDATE emp SET ename=?, ebirth=?, eaddr=?, eemail=? WHERE id=?";
	String sql_checkID = "SELECT * FROM emp WHERE id=?";
	
	public boolean insertEmp(EmpVO emp) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertE);
		//  pstmt.setString(1, emp.getEno()); 시퀀스로 변경
		    pstmt.setString(1, emp.getEname());
			pstmt.setString(2, emp.getEgender());
			pstmt.setString(3, emp.getEbirth());
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
	
//  모델에서 멤버DAO랑 관리자DAO에서 selectOne 메서드 로그인 성공여부를 받는 게 아니라 
//	객체를 받아야함(그래야지 객체를 들고 돌아다니기 가능)
	public EmpVO selectEmp(String id) {
		EmpVO emp = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectE);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				emp = new EmpVO();
				emp.setEname(rs.getString("ename"));
				emp.setEgender(rs.getString("egender"));
				emp.setEbirth(rs.getString("ebirth"));
				emp.setEaddr(rs.getString("eaddr"));
				emp.setEtel(rs.getString("etel"));
				emp.setEemail(rs.getString("eemail"));
				emp.setId(rs.getString("id"));
			}
		} catch (SQLException e) {
			System.out.println("EmpDAO select() 문제발생");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return emp;
	}
//	update(관리자정보)
	public void updateEmp(EmpVO emp) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateE);
			pstmt.setString(1, emp.getEname());
            pstmt.setString(2, emp.getEbirth());
            pstmt.setString(3, emp.getEaddr());
            pstmt.setString(4, emp.getEemail());
            pstmt.setString(5, emp.getId());
            pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
	}
	
	public boolean checkID(EmpVO emp) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_checkID);
			pstmt.setString(1, emp.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("존재하는 ID입니다.");
			}
		} catch(SQLException e) {
			System.out.println("EmpDAO checkID() 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return false;
	}
}
