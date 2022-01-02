package model.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드

public class NoticeDAO {
	private NoticeDAO(){}
	private static NoticeDAO NoticeIns = new NoticeDAO();
	public static NoticeDAO getInstance() {return NoticeIns;}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private String sql_insertN = "INSERT INTO notice VALUES(LPAD(notice_seq.NEXTVAL, 2, 0), ?, ?, ?)"; 
//	private String sql_selectAll = "SELECT * FROM notice ORDER BY nidx DESC";
	private String sql_selectAll = "SELECT ROWNUM, nidx, ntitle, ncont, writer FROM (SELECT * FROM notice ORDER BY nidx DESC) ORDER BY ROWNUM DESC";
	private String sql_selectOne = "SELECT * FROM notice WHERE nidx=?";
	private String sql_updateN = "UPDATE notice SET ntitle=?, ncont=? WHERE nidx=?";
	private String sql_deleteN = "DELETE FROM notice WHERE nidx = ?"; 
	private String sql_searchN = "SELECT * FROM board WHERE ntitle LIKE '%'||?||'%'"; // 제목 기반 검색 쿼리
	
	
	public boolean insertNotice(NoticeVO vo) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertN);
			pstmt.setString(1, vo.getNtitle());
			pstmt.setString(2, vo.getNcont());
			pstmt.setString(3, vo.getWriter()); // 작성자에 관리자를 어떻게 넣어야 되나.
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

	// 공지사항 가져오기 메서드
	// sql_selectAll = "SELECT * FROM notice";
	// 수정내용: 뷰단에서 구분하기 쉽도록 nlist, notice 변수명 변경, 인자값 삭제
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
	
	// 공지사항 본문, 필요한 메서드인 걸 어필한다!
	// sql_selectOne = "SELECT * FROM notice WHERE nidx=?";
	public NoticeVO selectOne(NoticeVO vo) {
		NoticeVO notice = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getNidx());
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
	
	// 공지사항 수정
	// sql_updateN = "UPDATE notice SET ntitle=?, ncont=? WHERE nidx=?";
	public boolean updateNotice(NoticeVO vo) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateN);
			pstmt.setString(1, vo.getNtitle());
			pstmt.setString(2, vo.getNcont());
			pstmt.setInt(3, vo.getNidx());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("NoticeDAO updateNotice(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
	// 관리자인지 확인하고 삭제를 허용한다. 수정 중	
	// sql_deleteN = "DELETE FROM notice WHERE nidx = ?"; 
	public boolean deleteNotice(NoticeVO vo) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_deleteN);
			pstmt.setInt(1, vo.getNidx());
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("NoticeDAO deleteNotice(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result == 1;
	}
	
	// 검색 메서드, SQL문 작성
	// sql_searchN = "SELECT * FROM board WHERE ntitle LIKE '%' || ? || '%'";
	public ArrayList<NoticeVO> searchNotice(String searchTitle) { // 인자로 뭘 받을 것인가
		ArrayList<NoticeVO> nlist = new ArrayList<>();
		NoticeVO notice = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_searchN);
			if(searchTitle != null && !searchTitle.equals("") && !searchTitle.equals(" ")) {
				pstmt.setString(1, searchTitle.trim());
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				notice = new NoticeVO();
				notice.setNidx(rs.getInt("nidx"));
				notice.setNtitle(rs.getString("ntitle"));
				notice.setNcont(rs.getString("ncont"));
				notice.setWriter(rs.getString("writer"));
				
				nlist.add(notice);
			}
		} catch(SQLException e) {
			System.out.println("NoticeDAO searchNotice(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return nlist.isEmpty()? null : nlist;
	}
}