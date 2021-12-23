package controller.member;

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
		MemberDAO dao = new MemberDAO();
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
		// if 문으로 감싸서 회원가입이 완료되면 main으로 가고 안되면 다시 시도하라고 써줄 예정 아직 고민중...
		dao.insertMember(vo);
		
		// 회원가입이 완료될 시 
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(true);
		return forward;
	}

}
