package model.contact;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class ContactDAO {
	private ContactDAO(){}
	private static ContactDAO ContactIns = new ContactDAO();
	public static ContactDAO getInstance() {return ContactIns;}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	private String sql_insertC = "INSERT INTO contact VALUES(LPAD(contact_seq.NEXTVAL, ?, ?, ?)";
	private String sql_selectAll = "SELECT * FROM contact";
	private String sql_selectOne = "SELECT * FROM contact WHERE msgno=?";
	private String sql_deleteC = "DELETE FROM contact WHERE msgno = ?";
	
	// 고객문의 작성()
	public boolean insertContact(ContactVO contact) {
		int result = 0;
		
		con= JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertC);
			pstmt.setString(1, contact.getMsgname());
			pstmt.setString(2, contact.getMsgemail());
			pstmt.setString(3, contact.getMsgtext());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("ContactVO writeContact(): "+ e +" 에러");
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
	public ContactVO selectOne(int msgno) {
		ContactVO contact = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setInt(1, msgno);
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
	public boolean deleteContact(int msgno) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_deleteC);
			pstmt.setInt(1, msgno);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("ContactDAO deleteContact(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
}
