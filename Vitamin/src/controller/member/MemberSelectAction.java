package controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.member.MemberDAO;
import model.member.MemberVO;

public class MemberSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// session에 존재하는 mid를 불러온다.
		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		
		MemberVO mdata = new MemberVO();
		// mdata 객체에 개인정보 보관 후 mdata에 mdata 객체 정보 저장
		mdata = dao.selectMember(vo);
		request.setAttribute("mdata", mdata);
		
		// mypage로 이동 -- 전달해야 할 데이터를 저장해줘서 mypage.do로 안가고 여기서 바로 jsp 파일로
		// 이동해도 될 거 같은데 혹시 mdata말고 다른 데이터를 보내줘야 되서 중간에 mypage.do를 들려야 되는 건지 혹시 다른 데이터 뭔지, 제가 깜빡한 거라면 말씀해주세요!
		ActionForward forward = new ActionForward();
		forward.setPath("mypage.jsp");
		forward.setRedirect(false);
		return forward;
	}

}