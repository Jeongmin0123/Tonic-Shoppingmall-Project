package model.contact;

public class ContactVO {
	private int msgno;
	private String msgname;
	private String msgemail;
	private String msgtext;
	
	public int getMsgno() {
		return msgno;
	}
	public void setMsgno(int msgno) {
		this.msgno = msgno;
	}
	public String getMsgname() {
		return msgname;
	}
	public void setMsgname(String msgname) {
		this.msgname = msgname;
	}
	public String getMsgemail() {
		return msgemail;
	}
	public void setMsgemail(String msgemail) {
		this.msgemail = msgemail;
	}
	public String getMsgtext() {
		return msgtext;
	}
	public void setMsgtext(String msgtext) {
		this.msgtext = msgtext;
	}
	
	@Override
	public String toString() {
		return "ContactVO [msgno=" + msgno + ", msgname=" + msgname + ", msgemail=" + msgemail + ", msgtext=" + msgtext
				+ "]";
	}
}
