package model.member;

public class MemberVO {
	// 속성(칼럼)
	private String mno;           
	private String mid;      
	private String mpw;      
	private String mname;   
	private String mgender; 
	private String mbirth;     
	private String maddr_zipcode;   
	private String maddr_street;   
	private String maddr_detail;   
	private String maddr_etc;   
	private String mtel;    
	private String memail;  
	private String mrole;  
	
	// 역할 칼럼 추가
	public String getMrole() {
		return mrole;
	}
	public void setMrole(String mrole) {
		this.mrole = mrole;
	}
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
	public String getMaddr_zipcode() {
		return maddr_zipcode;
	}
	public void setMaddr_zipcode(String maddr_zipcode) {
		this.maddr_zipcode = maddr_zipcode;
	}
	public String getMaddr_street() {
		return maddr_street;
	}
	public void setMaddr_street(String maddr_street) {
		this.maddr_street = maddr_street;
	}
	public String getMaddr_detail() {
		return maddr_detail;
	}
	public void setMaddr_detail(String maddr_detail) {
		this.maddr_detail = maddr_detail;
	}
	public String getMaddr_etc() {
		return maddr_etc;
	}
	public void setMaddr_etc(String maddr_etc) {
		this.maddr_etc = maddr_etc;
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
		return "MemberVO [mno="+mno+", mid="+mid+",mpw="+mpw+", mname="+mname
				+", mgender="+mgender+", mbirth="+mbirth+", maddr_zipcode="+maddr_zipcode
				+", maddr_street="+maddr_street+", maddr_detail="+maddr_detail+", maddr_etc="
				+maddr_etc+", mtel="+mtel+", memail="+memail+"]";
	}
}
