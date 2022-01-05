package model.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;
import model.notice.NoticeVO;

public class ContactDAO {
	private ContactDAO(){}
	private static ContactDAO ContactIns = new ContactDAO();
	public static ContactDAO getInstance() {return ContactIns;}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insertC = "INSERT INTO contact VALUES(LPAD(contact_seq.NEXTVAL,2,0), ?, ?, ?)";
	private String sql_selectAll = "SELECT * FROM contact";
	private String sql_selectOne = "SELECT * FROM contact WHERE msgno=?";
	private String sql_deleteC = "DELETE FROM contact WHERE msgno = ?";
	private String sql_searchC = "SELECT * FROM contact WHERE msgtext LIKE '%'||?||'%'";
	
	// 고객문의 작성()
	public boolean insertContact(ContactVO vo) {
		int result = 0;
		
		con= JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertC);
			pstmt.setString(1, vo.getMsgname());
			pstmt.setString(2, vo.getMsgemail());
			pstmt.setString(3, vo.getMsgtext());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("ContactVO insertContact(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
	// 고객문의 리스트()
	public ArrayList<ContactVO> selectAll() {
		ArrayList<ContactVO> clist = new ArrayList<ContactVO>();
		ContactVO contact = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				contact = new ContactVO();
				contact.setMsgno(rs.getInt("msgno"));
				contact.setMsgname(rs.getString("msgname"));
				contact.setMsgemail(rs.getString("msgemail"));
				contact.setMsgtext(rs.getString("msgtext"));
				
				clist.add(contact);
			}
		} catch(Exception e) {
			System.out.println("ContactDAO selectAll(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return clist.isEmpty()? null : clist;
	}
	
	// 고객문의 조회()
	public ContactVO selectOne(ContactVO vo) {
		ContactVO contact = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getMsgno());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				contact = new ContactVO();
				contact.setMsgno(rs.getInt("msgno"));
				contact.setMsgname(rs.getString("msgname"));
				contact.setMsgemail(rs.getString("msgemail"));
				contact.setMsgtext(rs.getString("msgtext"));
			}
		} catch(Exception e) {
			System.out.println("ContactDAO selectOne(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return contact;
	}
	
	// 관리자 권한 고객문의 삭제 메서드()
	public boolean deleteContact(ContactVO vo) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_deleteC);
			pstmt.setInt(1, vo.getMsgno());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("ContactDAO deleteContact(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
	// 검색 메서드, SQL문 작성
	// sql_searchC = "SELECT * FROM contact WHERE msgtext LIKE '%'||?||'%'";
	public ArrayList<ContactVO> searchContact(String searchMsg) { // 인자로 뭘 받을 것인가
		ArrayList<ContactVO> clist = new ArrayList<>();
		ContactVO contact = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_searchC);
			if(searchMsg != null && !searchMsg.equals("") && !searchMsg.equals(" ")) {
				pstmt.setString(1, searchMsg.trim());
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				contact = new ContactVO();
				contact.setMsgno(rs.getInt("msgno"));
				contact.setMsgname(rs.getString("msgname"));
				contact.setMsgemail(rs.getString("msgemail"));
				contact.setMsgtext(rs.getString("msgtext"));
				
				clist.add(contact);
			}
		} catch(SQLException e) {
			System.out.println("ContactDAO searchContact(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return clist.isEmpty()? null : clist;
	}
}