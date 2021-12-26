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
		// 일단은 회원 탈퇴가 되도록 해놓음
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		ActionForward forward = null;
		if(dao.deleteMember(vo)) {
			//회원 탈퇴 성공시 메인페이지로 이동
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
		} else {
			//회원 탈퇴 실패시 실패 문구 보이게 한 뒤 다시 회원탈퇴 페이지로
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보 삭제에 실패했습니다! 입력정보를 확인해보세요!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
