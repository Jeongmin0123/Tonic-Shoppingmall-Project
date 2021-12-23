package controller.notice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		NoticeDAO dao = new NoticeDAO();
		NoticeVO vo = new NoticeVO();
		vo.setNtitle(request.getParameter("ntitle"));
		vo.setNcont(request.getParameter("ncont"));
		vo.setWriter(request.getParameter("writer"));
		dao.insertNotice(vo);
		
		ActionForward forward = new ActionForward();
		forward.setPath("notice.do");
		forward.setRedirect(false);		
		return forward;
	}

}
