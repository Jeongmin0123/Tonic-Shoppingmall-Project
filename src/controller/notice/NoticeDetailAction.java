package controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int ndix = Integer.parseInt(request.getParameter("nidx"));
		
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO ndata = new NoticeVO();
		ndata = dao.selectOne(ndix);
		request.setAttribute("ndata", ndata);
		
		ActionForward forward = new ActionForward();
		forward.setPath("notice_detail.jsp");
		forward.setRedirect(false);		
		return forward;
	}

}
