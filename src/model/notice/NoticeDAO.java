package model.notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.common.JDBCUtil; // JDBCUtil(), disconnect() 메서드

public class NoticeDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	String sql_insertN = "INSERT INTO notice VALUES(notice_seq.NEXTVAL, ?, ?, ?)"; 
	String sql_selectOne="SELECT * FROM member WHERE id = ?";
	String sql_deleteN = "DELETE FROM notice WHERE nidx = ?"; 
	String sql_selectAll = "SELECT * FROM notice ORDER BY nidx DESC"; 
	
	public boolean insertNotice(NoticeVO notice) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertN);
		//	pstmt.setInt(1, notice.getNidx());
			pstmt.setString(1, notice.getNtitle());
			pstmt.setString(2, notice.getNcont());
			pstmt.setString(3, notice.getId());
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
/*  내가 아직 이해를 못한 것 같다.
	public boolean selectOne(NoticeVO notice) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setString(1, notice.getId());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("존재하는 ID입니다.");
			}
		} catch(SQLException e) {
			System.out.println("MemberDAO selectOne() 문제발생!");
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return false;
	}
*/
	
//  공지사항 게시물 구현 더 공부해서 완성하기.
	public ArrayList<NoticeVO> selectAll(){ // 몇개의 글을 볼수있는지에 대한 정보를 받아옴
		ArrayList<NoticeVO> datas = new ArrayList<NoticeVO>();
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				NoticeVO nvo = new NoticeVO();
				
				nvo.setNidx(rs.getInt("nidx")); // 시퀀스 ?? 
				nvo.setNtitle(rs.getString("ntitle"));
				nvo.setNcont(rs.getString("ncont"));
				nvo.setId(rs.getString("id"));
				
				datas.add(nvo);
			}
		} catch (SQLException e) {
			System.out.println("BoardDAO selectAll()에서 문제발생!");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}		
		return datas;
	}
//  관리자인지 확인하고 삭제를 허용한다. 수정 중	
	public boolean deleteNotice(NoticeVO notice) {
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_deleteN);
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
