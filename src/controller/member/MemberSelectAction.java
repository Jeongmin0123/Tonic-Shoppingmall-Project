package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.member.MemberDAO;

public class MemberSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO dao = new MemberDAO();
		dao.selectMember(id, pw);
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		return forward;
	}

}