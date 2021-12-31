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
		
		//View(jsp 파일)로부터 mid와 mpw를 받아온다.
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		ActionForward forward = null;
		
		
		if(dao.loginMember(vo)) {
			// 로그인 성공 시 vo에 회원정보를 입력
			vo = dao.selectMember(vo);
			// 로그인 성공시 session에 id 와 name 저장 후 main.jsp로 이동 예정
			// 기억 상으로는 이름도 session에 필요하다가 들었는데 보시고 필요 없으면 말씀해주세요 삭제 하겠습니다.
			HttpSession session = request.getSession();
			session.setAttribute("mid", vo.getMid());
			session.setAttribute("mname", vo.getMname());
			session.setAttribute("mrole", vo.getMrole());
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			// 로그인 실패시 로그인 실패 문구 띄운 뒤에 로그인 페이지로 이동
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인에 실패하였습니다. 아이디와 비밀번호를 확인해주세요!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
