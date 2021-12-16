package model.emp;

public class EmpVO {
//  속성(칼럼)
	private String eno;     // 예) EMP001 ??
	private String ename;   
	private String egender; 
	private int ebirth;     // 예) 950410 ??
	private String eaddr;   
	private String etel;    
	private String eemail;  
	private String id;
	
//  getter, setter
	public String getEno() {
		return eno;
	}
	public void setEno(String eno) {
		this.eno = eno;
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
	public int getEbirth() {
		return ebirth;
	}
	public void setEbirth(int ebirth) {
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "EmpVO [eno=" + eno + ", ename=" + ename + ", egender=" + egender + ", ebirth=" + ebirth + ", eaddr="
				+ eaddr + ", etel=" + etel + ", eemail=" + eemail + ", id=" + id + "]";
	}   
}
