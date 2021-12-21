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
	
	String sql_insertE = "INSERT INTO emp VALUES('EMP' || emp_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)";
	String sql_selectE = "SELECT * FROM emp WHERE id=? AND pw=?";
	String sql_updateE = "UPDATE emp SET ename=?, ebirth=?, eaddr=?, eemail=? WHERE id=?";
	String sql_checkID = "SELECT * FROM emp WHERE id=?";
	
	public boolean insertEmp(EmpVO emp) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertE);
		//  pstmt.setString(1, emp.getEno()); 시퀀스로 변경
			pstmt.setString(1, emp.getEid());
			pstmt.setString(2, emp.getEpw());
		    pstmt.setString(3, emp.getEname());
			pstmt.setString(4, emp.getEgender());
			pstmt.setString(5, emp.getEbirth());
			pstmt.setString(6, emp.getEaddr());
			pstmt.setString(7, emp.getEtel());
			pstmt.setString(8, emp.getEemail());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("EmpDAO insertEmp() 에러");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}
	
//  모델에서 멤버DAO랑 관리자DAO에서 selectOne 메서드 로그인 성공여부를 받는 게 아니라 
//	객체를 받아야함(그래야지 객체를 들고 돌아다니기 가능)
//	String sql_selectE = "SELECT * FROM emp WHERE id=? AND pw=?";
	public EmpVO selectEmp(String id, String pw) {
		EmpVO emp = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectE);
			pstmt.setString(1, id);
			pstmt.setString(1, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				emp = new EmpVO();
				emp.setEid(rs.getString("eid"));
				emp.setEname(rs.getString("ename"));
				emp.setEgender(rs.getString("egender"));
				emp.setEbirth(rs.getString("ebirth"));
				emp.setEaddr(rs.getString("eaddr"));
				emp.setEtel(rs.getString("etel"));
				emp.setEemail(rs.getString("eemail"));
			}
		} catch(SQLException e) {
			System.out.println("EmpDAO selectEmp() 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return emp;
	}
//	update(관리자정보) 
//  String sql_updateE = "UPDATE emp SET ename=?, ebirth=?, eaddr=?, eemail=? WHERE eno=?";
	public void updateEmp(EmpVO emp) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateE);
			pstmt.setString(1, emp.getEname());
            pstmt.setString(2, emp.getEbirth());
            pstmt.setString(3, emp.getEaddr());
            pstmt.setString(4, emp.getEemail());
            pstmt.setString(5, emp.getEno());
            pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("EmpDAO updateEmp() 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
	}
}
