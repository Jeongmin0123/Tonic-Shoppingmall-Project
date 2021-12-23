package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}
