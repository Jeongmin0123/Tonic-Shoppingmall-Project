package model.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드 
//  회원등록, 로그인 성공여부, 
public class MemberDAO {
	private MemberDAO(){}
	private static MemberDAO MemberIns = new MemberDAO();
	public static MemberDAO getInstance() {return MemberIns;}
//  MemberDAO member = new MemberDAO();
//  MemberDAO MemberIns = MemberDAO.getInstance();
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insertM = "INSERT INTO member VALUES ('MEM' || LPAD(member_seq.NEXTVAL, 3, 0),?,?,?,?,?,?,?,?,?,?,?)"; 
	private String sql_loginM = "SELECT * FROM member WHERE mid=?"; 
	private String sql_selectM = "SELECT * FROM member WHERE mid=?"; 
	private String sql_findIDbyTel = "SELECT id FROM member WHERE mtel=?"; 
//	String sql_selectForUp = "SELECT * FROM MEMBER WHERE id=? AND pw=?"; // updateMember()
	private String sql_updateM = "UPDATE member SET mname=?, mbirth=?, "
			+ "maddr_zipcode=?, maddr_street=?, maddr_detail=?, maddr_etc=?, "
			+ "memail=? WHERE mid=?"; 
	private String sql_getMemberList = "SELECT * FROM member"; 
	private String sql_isExistID = "SELECT * FROM member WHERE mid=?";
	private String sql_selectPW = "SELECT pw FROM member WHERE mid=?";      // deleteMember()
	private String sql_deleteM = "DELETE FROM member WHERE mid=? AND mpw=?"; // deleteMember()
	
	public boolean insertMember(MemberVO member) { // 파라미터 수정?
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertM);
		//  pstmt.setString(1, member.getMno()); "MEM" + 시퀀스
			pstmt.setString(1, member.getMid());
			pstmt.setString(2, member.getMpw());
		    pstmt.setString(3, member.getMname());
			pstmt.setString(4, member.getMgender());
			pstmt.setString(5, member.getMbirth());
			pstmt.setString(6, member.getMaddr_zipcode());
			pstmt.setString(7, member.getMaddr_street());
			pstmt.setString(8, member.getMaddr_detail());
			pstmt.setString(9, member.getMaddr_etc());
			pstmt.setString(10, member.getMtel());
			pstmt.setString(11, member.getMemail());
			result = pstmt.executeUpdate(); // 영향을 받은 행 수 반환 메서드
		} catch (SQLException e) {
			System.out.println("MemberDAO insertMember(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}

//  로그인 성공여부를 반환하는 메서드
//  boolean->int->로 변환, 경우의 수 3가지
	public boolean loginMember(MemberVO member) {
		int result = 0;
		
		con = JDBCUtil.connect(); 
		try {
			pstmt = con.prepareStatement(sql_loginM);
			pstmt.setString(1, member.getMid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("mpw").equals(member.getMpw())) {
					result = 1; // 로그인 성공 
				} else { 
					result = 0; // 비밀번호가 다를 때
				}
			}
		} catch(SQLException e) {
			System.out.println("MemberDAO checkLogin(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con); 
		}
		return result == 1; // result가 1이 아니라면 false 반환.
	}
	
//  모델에서 멤버DAO랑 관리자DAO에서 selectOne 메서드 로그인 성공여부를 받는 게 아니라 
//	객체를 받아야함(그래야지 객체를 들고 돌아다니기 가능)
//  String sql_selectM = "SELECT * FROM member WHERE id=?";
//  수정내용: loginfo 테이블 삭제, 쿼리문에 "and pw=?" 추가 -> 다시 삭제
	public MemberVO selectMember(MemberVO memberVO) {
		MemberVO member = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectM);
			pstmt.setString(1, memberVO.getMid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				member.setMid(rs.getString("mid"));
				member.setMpw(rs.getString("mpw"));
				member.setMname(rs.getString("mname"));
				member.setMgender(rs.getString("mgender"));
				member.setMbirth(rs.getString("mbirth"));
				member.setMaddr_zipcode(rs.getString("maddr_zipcode"));
				member.setMaddr_street(rs.getString("maddr_street"));
				member.setMaddr_detail(rs.getString("maddr_detail"));
				member.setMaddr_etc(rs.getString("maddr_etc"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
			}
		} catch(SQLException e) {
			System.out.println("MemberDAO selectMember(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return member;
	}
	
//  전화번호로 ID 찾기
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
			System.out.println("MemberDAO findIDbyTel(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return findID;
	}
	
//	update(회원정보)
//	String sql_updateM = "UPDATE member SET mname=?, mbirth=?,"
//				+ "maddr_zipcode=?, maddr_street=?, maddr_detail=?, maddr_etc=?, "
//				+ "memail=? WHERE id=?"; // updateMember()
//  수정내용: WHERE절 id
	public boolean updateMember(MemberVO member) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateM);
			pstmt.setString(1, member.getMname());
            pstmt.setString(2, member.getMbirth());
//          pstmt.setString(3, member.getMaddr_zipcode()+" "
//          		+member.getMaddr_street()+" "+member.getMaddr_detail());
            pstmt.setString(3, member.getMaddr_zipcode());
            pstmt.setString(4, member.getMaddr_street());
            pstmt.setString(5, member.getMaddr_detail());
            pstmt.setString(6, member.getMaddr_etc());
            pstmt.setString(7, member.getMemail());
            pstmt.setString(8, member.getMid());
            result = pstmt.executeUpdate(); 
		} catch(Exception e) {
			System.out.println("MemberDAO updateMember(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
//  관리자가 회원정보 가져오기 메서드(), 계정은 관리자여야 한다. 아직 페이지 구현X
//  String sql_getMemberList = "SELECT * FROM member";
	public ArrayList<MemberVO> getMemberList() {
		ArrayList<MemberVO> mlist = new ArrayList<MemberVO>();
		MemberVO member = null; 
		String pwOrigin; 
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
				member.setMaddr_zipcode(rs.getString("maddr_zipcode"));
				member.setMaddr_street(rs.getString("maddr_street"));
				member.setMaddr_detail(rs.getString("maddr_detail"));
				member.setMaddr_etc(rs.getString("maddr_etc"));
				member.setMtel(rs.getString("mtel"));
				member.setMemail(rs.getString("memail"));
				
				mlist.add(member);
			}
		} catch(Exception e) {
			System.out.println("MemberDAO getMemberList(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return mlist.isEmpty()? null : mlist;
	}	
	
//  isExistID, 해당 ID가 존재하는가 
//  String sql_isExistID = "SELECT * FROM member WHERE id=?";
	public boolean isExistID(String id) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_isExistID);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("MemberDAO isExistID(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
//  delete(ID) 아직 수정 중
//	String sql_selectPW = "SELECT pw FROM member WHERE id=?";    
//	String sql_deleteM = "DELETE FROM member WHERE id=? AND pw=?"; 
	public boolean deleteMember(String id, String pw) {
		String MemberPW = null; 
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
			System.out.println("MemberDAO deleteMember(): "+ e +"에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result == 1;
	}
}