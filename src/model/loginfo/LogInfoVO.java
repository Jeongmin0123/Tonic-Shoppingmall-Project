package model.loginfo;

public class LogInfoVO {
//  속성(칼럼)
	private String log_code;      
	private String id;   
	private String pw;
	
//  getter, setter
	public String getLog_code() {
		return log_code;
	}
	public void setLog_code(String log_code) {
		this.log_code = log_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

}
