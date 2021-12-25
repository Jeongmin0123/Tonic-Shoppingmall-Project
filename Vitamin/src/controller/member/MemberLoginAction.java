package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;
import model.member.MemberDAO;
import model.member.MemberVO;

public class MemberLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		ActionForward forward = null;
		
		System.out.println(vo);
		if(dao.loginMember(vo)) {
			HttpSession session = request.getSession();
			session.setAttribute("mid", vo.getMid());
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인에 실패하였습니다. 아이디와 비밀번호를 확인해주세요!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
