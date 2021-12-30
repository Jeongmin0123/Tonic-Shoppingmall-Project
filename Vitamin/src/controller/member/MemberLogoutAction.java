package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();		// session.removeAttribute("mid + mname"); 와 같음, session에 저장된 값을 제거함
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		return forward;
	}

}
