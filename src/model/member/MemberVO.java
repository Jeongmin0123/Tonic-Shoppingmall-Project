package model.member;

public class MemberVO {
	// 속성(칼럼)
	private String mno;     // 예) MEM001 ??
	private String mid;      
	private String mpw;      
	private String mname;   
	private String mgender; 
	private String mbirth;     // 예) 950410 ??
	private String maddr;   
	private String mtel;    
	private String memail;  
	
	// getter, setter
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMpw() {
		return mpw;
	}
	public void setMpw(String mpw) {
		this.mpw = mpw;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	public String getMgender() {
		return mgender;
	}
	public void setMgender(String mgender) {
		this.mgender = mgender;
	}
	public String getMbirth() {
		return mbirth;
	}
	public void setMbirth(String mbirth) {
		this.mbirth = mbirth;
	}
	public String getMaddr() {
		return maddr;
	}
	public void setMaddr(String maddr) {
		this.maddr = maddr;
	}
	public String getMtel() {
		return mtel;
	}
	public void setMtel(String mtel) {
		this.mtel = mtel;
	}
	public String getMemail() {
		return memail;
	}
	public void setMemail(String memail) {
		this.memail = memail;
	}
	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mgender=" + mgender + ", mbirth=" + mbirth + ", maddr="
				+ maddr + ", mtel=" + mtel + ", memail=" + memail + "]";
	}
}
