package model.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드

public class NoticeDAO {
	Connection con;
	PreparedStatement pstmt;
//	ResultSet rs;

	String sql_insert = "INSERT INTO notice(nidx, id, ncont) VALUES((SELECT nvl(max(nidx), 0)+1 FROM notice),?,?)"; // 로그인에 성공한 경우에만 C 진행
	String sql_delete = "DELETE FROM notice WHERE nidx=?"; // 해당 게시글의 작성자만이 삭제가능
//	String sql_selectAll = "SELECT * FROM emp WHERE rownum<=? ORDER BY bid DESC"; // "더보기": pagination(페이지네이션)
	
	public boolean insert(NoticeVO notice) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insert);
			pstmt.setString(1, notice.getId());
			pstmt.setString(2, notice.getNcont());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("NoticeDAO insert() 문제 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}
	
	public boolean delete(NoticeVO notice) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_delete);
			pstmt.setInt(1, notice.getNidx());
			pstmt.executeUpdate();
		} catch(SQLException e) {
			System.out.println("NoticeDAO delete() 문제 발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return true;
	}
}
