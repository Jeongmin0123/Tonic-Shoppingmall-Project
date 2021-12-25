package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;
import model.member.MemberDAO;
import model.member.MemberVO;

public class MemberUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("mid");
		vo.setMname(request.getParameter("mname"));
		vo.setMbirth(request.getParameter("mbirth"));
		vo.setMaddr_zipcode(request.getParameter("maddr_zipcode"));
		vo.setMaddr_street(request.getParameter("maddr_street"));
		vo.setMaddr_detail(request.getParameter("maddr_detail"));
		vo.setMaddr_etc(request.getParameter("maddr_etc"));
		vo.setMemail(request.getParameter("memail"));
		vo.setMid(id);
		
		ActionForward forward = null;
		if(dao.updateMember(vo)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보 수정에 실패했습니다! 입력정보를 확인해보세요!');history.go(-1);</script>");
		}
		return forward;
	}

}
