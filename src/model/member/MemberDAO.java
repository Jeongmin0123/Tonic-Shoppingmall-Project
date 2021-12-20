package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드
import model.loginfo.LogInfoVO; 

public class MemberDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insertM = "INSERT INTO member VALUES('MEM'||mem_seq.NEXTVAL, ?, ?, ?, ?, ?, ?, ?)";
	String sql_selectM = "SELECT * FROM member WHERE id=?";
	String sql_findIDbyTel = "SELECT id FROM member WHERE tel=?";
	String sql_updateM = "UPDATE member SET mname=?, mbirth=?, maddr=?, memail=? WHERE id=?";
	String sql_selectPW = "SELECT pw FROM loginfo WHERE id=?";
	String sql_deleteM = "DELETE FROM member WHERE id=?";
//	String sql_deleteL = "DELETE FROM member WHERE id=? AND pw=?";
	
	public boolean insert(MemberVO member) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertM);
		//  pstmt.setString(1, member.getMno()); 시퀀스로 변경예정
		    pstmt.setString(1, member.getMname());
			pstmt.setString(2, member.getMgender());
			pstmt.setString(3, member.getMbirth());
			pstmt.setString(4, member.getMaddr());
			pstmt.setString(5, member.getMtel());
			pstmt.setString(6, member.getMemail());
			pstmt.setString(7, member.getId());
			pstmt.executeUpdate(); // 영향을 받은 행 수 반환 메서드
		} catch (SQLException e) {
			System.out.println("MemberDAO insert() 문제발생");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}
	
//  모델에서 멤버DAO랑 관리자DAO에서 selectOne 메서드 로그인 성공여부를 받는 게 아니라 
//	객체를 받아야함(그래야지 객체를 들고 돌아다니기 가능)
	public MemberVO select(String id) {
		con = JDBCUtil.connect();
		MemberVO vo = null;
		try {
			pstmt = con.prepareStatement(sql_selectM);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO();
				vo.setMno(rs.getString("mno"));
				vo.setMname(rs.getString("mname"));
				vo.setMgender(rs.getString("mgender"));
				vo.setMbirth(rs.getString("mbirth"));
				vo.setMaddr(rs.getString("maddr"));
				vo.setMtel(rs.getString("mtel"));
				vo.setMemail(rs.getString("memail"));
				vo.setId(rs.getString("id"));
			}
		} catch (SQLException e) {
			System.out.println("MemberDAO select() 문제발생");
			e.printStackTrace();
		//	return vo;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return vo;
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
	
//	update(회원정보)
	public void update(MemberVO member) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateM);
			pstmt.setString(1, member.getMname());
            pstmt.setString(2, member.getMbirth());
            pstmt.setString(3, member.getMaddr());
            pstmt.setString(4, member.getMemail());
            pstmt.setString(5, member.getId());
            pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
	}
	
//  delete(ID) 아직 수정 중
//	public boolean delete(String id) {
	public boolean delete(String id, String pw) {
	//  SQL : selectPW, deleteM
		ResultSet rs = null;
		boolean result = false; // 삭제 성공 == true, 메세지 반환
		String LogInfopw = null; // loginfo 테이블의 비밀번호를 넣을 변수
		
		con = JDBCUtil.connect();
		try { 
			pstmt = con.prepareStatement(sql_selectPW);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				LogInfopw = rs.getString("pw");
				if(LogInfopw.equals(pw)) {
					pstmt = con.prepareStatement(sql_deleteM);
					pstmt.setString(1, id);
					pstmt.executeUpdate();
					result = true;
				} else {
					result = false;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result;
	}
}