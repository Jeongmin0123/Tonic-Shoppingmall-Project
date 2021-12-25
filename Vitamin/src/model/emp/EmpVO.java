package model.emp;

public class EmpVO {
//  속성(칼럼)
	private String eno;    
	private String ename;   
	private String eid;
	private String epw;
	private String egender; 
	private String ebirth;  
	private String eaddr;   
	private String etel;    
	private String eemail;  
	
	//  getter, setter
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
	}
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEpw() {
		return epw;
	}
	public void setEpw(String epw) {
		this.epw = epw;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEgender() {
		return egender;
	}
	public void setEgender(String egender) {
		this.egender = egender;
	}
	public String getEbirth() {
		return ebirth;
	}
	public void setEbirth(String ebirth) {
		this.ebirth = ebirth;
	}
	public String getEaddr() {
		return eaddr;
	}
	public void setEaddr(String eaddr) {
		this.eaddr = eaddr;
	}
	public String getEtel() {
		return etel;
	}
	public void setEtel(String etel) {
		this.etel = etel;
	}
	public String getEemail() {
		return eemail;
	}
	public void setEemail(String eemail) {
		this.eemail = eemail;
	}
	@Override
	public String toString() {
		return "EmpVO [eno=" + eno + ", eid=" + eid + ", epw=" + epw + ", ename=" + ename + ", egender=" + egender + ", ebirth=" + ebirth + ", eaddr="
				+ eaddr + ", etel=" + etel + ", eemail=" + eemail + "]";
	}   
}
