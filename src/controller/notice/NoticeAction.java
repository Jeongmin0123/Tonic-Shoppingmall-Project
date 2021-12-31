package controller.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ndatas에 공지사항들을 저장한다
		NoticeDAO dao = NoticeDAO.getInstance();
		ArrayList<NoticeVO> ndatas=dao.selectAll();	
		request.setAttribute("ndatas", ndatas);
		
		// notice.jsp 페이지가 나오도록 한다.
		ActionForward forward = new ActionForward();
		forward.setPath("notice.jsp");
		forward.setRedirect(false);		
		return forward;
	}

}
