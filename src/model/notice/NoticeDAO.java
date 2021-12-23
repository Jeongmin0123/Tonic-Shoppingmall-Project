package model.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드
import model.emp.EmpDAO;

public class NoticeDAO {
	private NoticeDAO(){}
	private static NoticeDAO NoticeIns = new NoticeDAO();
	public static NoticeDAO getInstance() {return NoticeIns;}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private String sql_insertN = "INSERT INTO notice VALUES(LPAD(notice_seq.NEXTVAL, 2, 0), ?, ?, ?)"; 
	private String sql_selectAll = "SELECT * FROM notice";
	private String sql_selectOne = "SELECT * FROM notice WHERE nidx=?";
	private String sql_updateN = "UPDATE notice SET ntitle=?, ncont=? WHERE nidx=?";
	private String sql_deleteN = "DELETE FROM notice WHERE nidx = ?"; 
	
	public boolean insertNotice(NoticeVO notice) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertN);
		//	pstmt.setString(1, notice.getNidx());
			pstmt.setString(1, notice.getNtitle());
			pstmt.setString(2, notice.getNcont());
			pstmt.setString(3, notice.getWriter()); // 작성자에 관리자를 어떻게 넣어야 되나.
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("NoticeDAO insertNotice(): "+ e +" 에러");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}

//  공지사항 가져오기 메서드
//  String sql_selectAll = "SELECT * FROM notice";
//  수정내용: 뷰단에서 구분하기 쉽도록 nlist, notice 변수명 변경, 인자값 삭제
	public ArrayList<NoticeVO> selectAll() {
		ArrayList<NoticeVO> nlist = new ArrayList<NoticeVO>();
		NoticeVO notice = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				notice = new NoticeVO();
				notice.setNidx(rs.getInt("nidx"));
				notice.setNtitle(rs.getString("ntitle"));
				notice.setNcont(rs.getString("ncont"));
				notice.setWriter(rs.getString("writer"));
				
				nlist.add(notice);
			}
		} catch(Exception e) {
			System.out.println("NoticeDAO selectAll(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return nlist.isEmpty()? null : nlist;
	}
	
//	공지사항 본문, 필요한 메서드인 걸 어필한다!
//  String sql_selectOne = "SELECT * FROM notice WHERE nidx=?";
	public NoticeVO selectOne(int index) {
		NoticeVO notice = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setInt(1, index);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				notice = new NoticeVO();
				notice.setNidx(rs.getInt("nidx"));
				notice.setNtitle(rs.getString("ntitle"));
				notice.setNcont(rs.getString("ncont"));
				notice.setWriter(rs.getString("writer"));
			}
		} catch(Exception e) {
			System.out.println("NoticeDAO selectOne(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return notice;
	}
	
//  공지사항 수정
//  String sql_updateN = "UPDATE notice SET ntitle=?, ncont=? WHERE nidx=?";
	public boolean updateNotice(int index, String upTitle, String upCont) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateN);
			pstmt.setString(1, upTitle);
			pstmt.setString(2, upCont);
			pstmt.setInt(3, index);
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("NoticeDAO updateNotice(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
//  관리자인지 확인하고 삭제를 허용한다. 수정 중	
//	String sql_deleteN = "DELETE FROM notice WHERE nidx = ?"; 
	public boolean deleteNotice(int index) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_deleteN);
			pstmt.setInt(1, index);
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("NoticeDAO deleteNotice(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result == 1;
	}
}
