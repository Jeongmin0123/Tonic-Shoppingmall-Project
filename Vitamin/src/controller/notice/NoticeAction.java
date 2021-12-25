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
		
		NoticeDAO dao = NoticeDAO.getInstance();
		ArrayList<NoticeVO> ndatas=dao.selectAll();	
		request.setAttribute("ndatas", ndatas);
		
		ActionForward forward = new ActionForward();
		forward.setPath("notice.jsp");
		forward.setRedirect(false);		
		return forward;
	}

}
