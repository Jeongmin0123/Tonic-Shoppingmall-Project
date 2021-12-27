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
		// 세션에 저장되어 있는 id 값 가져온 뒤 sql문에서 id로 판별해야 하므로 id값 설정
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("mid");
		vo.setMid(id);
		
		// 수정하거나 입력된 값들을 받아오기
		vo.setMname(request.getParameter("mname"));
		vo.setMbirth(request.getParameter("mbirth"));
		vo.setMaddr_zipcode(request.getParameter("maddr_zipcode"));
		vo.setMaddr_street(request.getParameter("maddr_street"));
		vo.setMaddr_detail(request.getParameter("maddr_detail"));
		vo.setMaddr_etc(request.getParameter("maddr_etc"));
		vo.setMemail(request.getParameter("memail"));
		
		ActionForward forward = null;
		if(dao.updateMember(vo)) {
			// 회원정보 수정이 성공하면 main.jsp 페이지로 이동하기 위해서 main.do 실행
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(false);
		} else {
			// 수정 실패시 회원정보 수정이 실패했다는 alert 창 띄운 후 다시 수정하도록 전 페이지로 감
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원정보 수정에 실패했습니다! 입력정보를 확인해보세요!');history.go(-1);</script>");
		}
		return forward;
	}

}
