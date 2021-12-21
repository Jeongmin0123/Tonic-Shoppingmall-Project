package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드 

public class MemberDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	String sql_insertM = "INSERT INTO member VALUES('MEM' || LPAD(mem_seq.NEXTVAL, 3, 0), ?, ?, ?, ?, ?, ?, ?, ?)"; // insertMember()
	String sql_selectM = "SELECT * FROM member WHERE id=? and pw=?"; // selectMember()
	String sql_findIDbyTel = "SELECT id FROM member WHERE tel=?"; // findIDbyTel()
	String sql_selectForUp = "SELECT * FROM MEMBER WHERE id=? AND pw=?";                      // updateMember()
	String sql_updateM = "UPDATE member SET mname=?, mbirth=?, maddr=?, memail=? WHERE id=?"; // updateMember()
	String sql_getMemberList = "SELECT * FROM member"; // getMemberList()
	String sql_selectPW = "SELECT pw FROM member WHERE id=?";     // deleteMember()
	String sql_deleteM = "DELETE FROM member WHERE id=? AND pw=?"; // deleteMember()
	
	public boolean insertMember(MemberVO member) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertM);
		//  pstmt.setString(1, member.getMno()); "MEM" + 시퀀스
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
		    pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMgender());
			pstmt.setString(5, member.getMbirth());
			pstmt.setString(6, member.getMaddr());
			pstmt.setString(7, member.getMtel());
			pstmt.setString(8, member.getMemail());
			pstmt.executeUpdate(); // 영향을 받은 행 수 반환 메서드
		} catch (SQLException e) {
			System.out.println("MemberDAO insertMember() 에러");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}

//  모델에서 멤버DAO랑 관리자DAO에서 selectOne 메서드 로그인 성공여부를 받는 게 아니라 
//	객체를 받아야함(그래야지 객체를 들고 돌아다니기 가능)
//  selectMember()
//  String sql_selectM = "SELECT * FROM member WHERE id=? and pw=?";
//  수정내용: loginfo 테이블 삭제로 쿼리문에 "and pw=?" 추가
	public MemberVO selectMember(String id, String pw) {
		MemberVO member = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectM);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setMid(rs.getString("mid"));
				member.setMpw(rs.getString("mpw"));
				member.setMname(rs.getString("mname"));
				member.setMgender(rs.getString("mgender"));
				member.setMbirth(rs.getString("mbirth"));
				member.setMaddr(rs.getString("maddr"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
			}
		} catch(SQLException e) {
			System.out.println("MemberDAO selectMember() 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return member;
	}
	
//  findIDbyTel, 전화번호로 ID 찾기
	public String findIDbyTel(String tel) { 
		String findID = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_findIDbyTel);
			pstmt.setString(1, tel);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				findID = rs.getString("mid");
			}
		} catch(Exception e) {
			System.out.println("MemberDAO findIDbyTel() 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return findID;
	}
	
//	update(회원정보)
//	String sql_updateM = "UPDATE member SET mname=?, mbirth=?, maddr=?, memail=? WHERE mno=?";
//  수정내용: WHERE절을 id가 아닌 mno로 변경
	public boolean updateMember(MemberVO member) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateM);
			pstmt.setString(1, member.getMname());
            pstmt.setString(2, member.getMbirth());
            pstmt.setString(3, member.getMaddr());
            pstmt.setString(4, member.getMemail());
            pstmt.setString(5, member.getMno());
            result = pstmt.executeUpdate(); // 잘 수행되었다면 1이 들어간다. 
		} catch(Exception e) {
			System.out.println("MemberDAO updateMember() 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1; // 제대로 수정이 되었다면 true(1), 안됐다면 false(0)
	}
	
//  관리자가 회원정보 가져오기 메서드(), 계정은 관리자여야 한다. 아직 페이지 구현X
//  String sql_getMemberList = "SELECT * FROM member";
	public ArrayList<MemberVO> getMemberList() {
		ArrayList<MemberVO> mlist = new ArrayList<MemberVO>();
		MemberVO member = null; 
		String pwOrigin; // user_password
		int pwLength = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_getMemberList);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				member = new MemberVO();
			//  비밀번호는 인덱스[0] + '*'로 보여지기 
				pwOrigin = rs.getString("pw");
				pwLength = pwOrigin.length()-1; 
				pwOrigin = pwOrigin.substring(0, 1);
				while(pwLength > 0) {
					pwOrigin += "*"; 
					--pwLength;
				}
				member.setMno(rs.getString("mno"));
				member.setMid(rs.getString("mid"));
				member.setMpw(rs.getString("mpw"));
				member.setMname(rs.getString("mname"));
				member.setMgender(rs.getString("mgender"));
				member.setMbirth(rs.getString("mbirth"));
				member.setMaddr(rs.getString("maddr"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				
				mlist.add(member);
			}
		} catch(Exception e) {
			System.out.println("MemberDAO getMemberList() 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return mlist.isEmpty()? null : mlist;
	}	
	
//  delete(ID) 아직 수정 중
//	String sql_selectPW = "SELECT pw FROM member WHERE id=?";    
//	String sql_deleteM = "DELETE FROM member WHERE id=? AND pw=?"; 
	public boolean deleteMember(String id, String pw) {
		String MemberPW = null; // loginfo 테이블의 비밀번호를 넣을 변수
		int result = 0;  // 삭제 성공 == true, 메세지 반환
		
		con = JDBCUtil.connect();
		try { 
			pstmt = con.prepareStatement(sql_selectPW);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberPW = rs.getString("pw");
				if(MemberPW.equals(pw)) {
					pstmt = con.prepareStatement(sql_deleteM);
					pstmt.setString(1, id);
					pstmt.setString(2, pw);
					result = pstmt.executeUpdate();
				} else {
					System.out.println("비밀번호가 일치하지 않습니다.");
				}
			}
		} catch(Exception e) {
			System.out.println("MemberDAO deleteMember() 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result == 1;
	}
}