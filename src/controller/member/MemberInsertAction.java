package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.member.MemberDAO;
import model.member.MemberVO;

public class MemberInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 회원가입시 DB에 회원정보를 넣어주는 액션
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo.setMname(request.getParameter("mname"));
		vo.setMgender(request.getParameter("mgender"));
		vo.setMbirth(request.getParameter("mbirth"));
		vo.setMaddr_zipcode(request.getParameter("maddr_zipcode"));
		vo.setMaddr_street(request.getParameter("maddr_street"));
		vo.setMaddr_detail(request.getParameter("maddr_detail"));
		vo.setMaddr_etc(request.getParameter("maddr_etc"));
		vo.setMtel(request.getParameter("mtel"));
		vo.setMemail(request.getParameter("memail"));
		
		ActionForward forward = null;
		// if 문으로 감싸서 회원가입이 완료되면 main으로 가고 안되면 회원가입 실패 창 띄운 후 다시 회원가입 창으로
		if(dao.insertMember(vo)) {
			forward = new ActionForward();
			forward.setPath("main.do");
			forward.setRedirect(true);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('회원가입에 실패하였습니다!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
