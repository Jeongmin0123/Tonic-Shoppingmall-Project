package model.notice;
//private int rcnt; 테이블 칼럼으로는 존재하지 않으나, 로직적으로 필요한 속성!
/*
공지사항 테이블(notice) 
  · 게시물 번호(PK) = nidx 
  · 제목 = ntitle 
  · 내용 = ncont // notice + contents
*/
public class NoticeVO {
	private int nidx;
	private String ntitle;
	private String ncont;
	private String writer;
	
	public int getNidx() {
		return nidx;
	}
	public void setNidx(int nidx) {
		this.nidx = nidx;
	}
	public String getNtitle() {
		return ntitle;
	}
	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}
	public String getNcont() {
		return ncont;
	}
	public void setNcont(String ncont) {
		this.ncont = ncont;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
}
