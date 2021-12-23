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
		// 받아올 때 mem인지 emp인지 확인후에 진행해야 하지만 아직 이 부분이 어떻게 될 지 몰라서 두 개의 메서드로 제작 후 합칠 예정
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo.setMname(request.getParameter("mname"));
		vo.setMgender(request.getParameter("mgender"));
		vo.setMbirth(request.getParameter("mbirth"));
		vo.setMaddr_zipcode(request.getParameter(""));
		vo.setMtel(request.getParameter("mtel"));
		vo.setMemail(request.getParameter("memail"));
		dao.insertMember(vo);
		
		// 이 부분에 메인 페이지에서 보여줄 데이터를 설정해줘야 하는데 아직 메인페이지의 데이터 부분이 완성되지 않아 비워놨습니다.
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
