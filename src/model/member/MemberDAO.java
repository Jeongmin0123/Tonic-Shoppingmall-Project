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
//  MemberDAO member = new MemberDAO(); (X)
//  MemberDAO MemberIns = MemberDAO.getInstance(); (O)
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insertM = "INSERT INTO member(mno, mid, mpw, mname, mgender, "
			+ "mbirth, maddr_zipcode, maddr_street, maddr_detail, maddr_etc, mtel, memail) "
			+ "VALUES"
			+ "('MEM' || LPAD(member_seq.NEXTVAL, 3, 0),?,?,?,?,?,?,?,?,?,?,?)"; 
	private String sql_loginM = "SELECT * FROM member WHERE mid=?"; 
	private String sql_selectM = "SELECT * FROM member WHERE mid=?"; 
	private String sql_findIDbyTel = "SELECT mid FROM member WHERE mtel=?"; 
//	private String sql_updateM1 = "UPDATE member SET mname=?, mbirth=?,"
//			+ "maddr_zipcode=?, maddr_street=?, maddr_detail=?, maddr_etc=?,"
//			+ "memail=? WHERE mid=?"; 
//	private String sql_updateM2 = "UPDATE member a SET mname=?, mbirth=?,"
//			+ "maddr_zipcode=?, maddr_street=?, maddr_detail=?, maddr_etc=?,"
//			+ "memail=? WHERE EXISTS (SELECT 1 FROM member b WHERE a.mno = b.mno AND a.mid = ?"; 
//	private String sql_updateM3 = "UPDATE member a SET mname=?, mbirth=?,"
//			+ "maddr_zipcode=?, maddr_street=?, maddr_detail=?, maddr_etc=?,"
//			+ "memail=? WHERE EXISTS (SELECT * FROM member WHERE mid = ?"; 
	private String sql_updateM = "UPDATE member SET mname=nvl(?, mname), mgender=nvl(?, mgender), "
			+ "mbirth=nvl(?, mbirth), maddr_zipcode=nvl(?, maddr_zipcode), maddr_street=nvl(?, maddr_street), "
			+ "maddr_detail=nvl(?, maddr_detail), maddr_etc=nvl(?, maddr_etc), mtel=nvl(?, mtel), "
			+ "memail=nvl(?, memail) WHERE mid = ?";
	private String sql_getMemberList = "SELECT * FROM member"; 
	private String sql_isExistID = "SELECT * FROM member WHERE mid=?";
	private String sql_selectPW = "SELECT mpw FROM member WHERE mid=?";      
	private String sql_deleteM = "DELETE FROM member WHERE mid=? AND mpw=?"; 
	
	public boolean insertMember(MemberVO vo) { 
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertM);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
		    pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getMgender());
			pstmt.setString(5, vo.getMbirth());
			pstmt.setString(6, vo.getMaddr_zipcode());
			pstmt.setString(7, vo.getMaddr_street());
			pstmt.setString(8, vo.getMaddr_detail());
			pstmt.setString(9, vo.getMaddr_etc());
			pstmt.setString(10, vo.getMtel());
			pstmt.setString(11, vo.getMemail());
			result = pstmt.executeUpdate(); // 영향을 받은 행 수 반환 메서드
		} catch (SQLException e) {
			System.out.println("MemberDAO insertMember(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}

//  로그인 성공여부()
//  boolean->int->로 변환, 경우의 수 3가지
	public boolean loginMember(MemberVO vo) {
		int result = 0;
		
		con = JDBCUtil.connect(); 
		try {
			pstmt = con.prepareStatement(sql_loginM);
			pstmt.setString(1, vo.getMid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString("mpw").equals(vo.getMpw())) {
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
	public MemberVO selectMember(MemberVO vo) {
		MemberVO member = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectM);
			pstmt.setString(1, vo.getMid());
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
				member.setMrole(rs.getString("mrole"));
			}
		} catch(SQLException e) {
			System.out.println("MemberDAO selectMember(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return member;
	}
	
	// 전화번호로 ID 찾기
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
//  수정내용: WHERE절 id
	public boolean updateMember(MemberVO vo) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateM);
			pstmt.setString(1, vo.getMname());
			pstmt.setString(2, vo.getMgender());
            pstmt.setString(3, vo.getMbirth());
            pstmt.setString(4, vo.getMaddr_zipcode());
            pstmt.setString(5, vo.getMaddr_street());
            pstmt.setString(6, vo.getMaddr_detail());
            pstmt.setString(7, vo.getMaddr_etc());
            pstmt.setString(8, vo.getMtel());
            pstmt.setString(9, vo.getMemail());
            pstmt.setString(10, vo.getMid());
            result = pstmt.executeUpdate(); 
		} catch(Exception e) {
			System.out.println("MemberDAO updateMember(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
//  관리자가 회원정보 가져오기 메서드(), 계정은 관리자, 아직 페이지 구현X
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
				pwOrigin = rs.getString("mpw");
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
				member.setMrole(rs.getString("mrole"));
				
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
	
//  ID 중복확인() 
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
	
//  삭제()
//	String sql_selectPW = "SELECT pw FROM member WHERE id=?";    
//	String sql_deleteM = "DELETE FROM member WHERE id=? AND pw=?"; 
	public boolean deleteMember(MemberVO vo) {
		String MemberPW = null; 
		int result = 0; 
		
		con = JDBCUtil.connect();
		try { 
			pstmt = con.prepareStatement(sql_selectPW);
			pstmt.setString(1, vo.getMid());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				MemberPW = rs.getString("mpw");
				if(MemberPW.equals(vo.getMpw())) {
					pstmt = con.prepareStatement(sql_deleteM);
					pstmt.setString(1, vo.getMid());
					pstmt.setString(2, vo.getMpw());
					result = pstmt.executeUpdate();
				}
			}
		} catch(Exception e) {
			System.out.println("MemberDAO deleteMember(): "+ e + " 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result == 1;
	}
}