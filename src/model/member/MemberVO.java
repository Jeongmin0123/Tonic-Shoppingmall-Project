package model.member;

public class MemberVO {
	// 속성(칼럼)
	private String mno;     // 예) MEM001 ??
	private String mname;   
	private String mgender; 
	private int mbirth;     // 예) 950410 ??
	private String maddr;   
	private String mtel;    
	private String memail;  
	private String id;      
	
	// getter, setter
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
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
	public int getMbirth() {
		return mbirth;
	}
	public void setMbirth(int mbirth) {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "MemberVO [mno=" + mno + ", mname=" + mname + ", mgender=" + mgender + ", mbirth=" + mbirth + ", maddr="
				+ maddr + ", mtel=" + mtel + ", memail=" + memail + ", id=" + id + "]";
	}
}
