package controller.common;

public class ActionForward {
	private boolean redirect;	
	private String path;		
	
	// redirect방식 T : 전달할 정보가 없음
	// forward 방식 F : 전달할 정보가 있음
	
	public boolean isRedirect() {
		return redirect;
	}
	public void setRedirect(boolean redirect) {
		this.redirect = redirect;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
}
