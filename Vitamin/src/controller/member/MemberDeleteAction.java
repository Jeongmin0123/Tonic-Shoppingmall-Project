package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;
import model.member.MemberDAO;
import model.member.MemberVO;

public class MemberDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		String id = request.getParameter("mid");
		String pw = request.getParameter("mpw");
		ActionForward forward = null;
		if(dao.deleteMember(id, pw)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보 삭제에 실패했습니다! 입력정보를 확인해보세요!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
