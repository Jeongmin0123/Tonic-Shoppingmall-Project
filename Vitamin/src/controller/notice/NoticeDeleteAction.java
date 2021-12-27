package controller.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 인자로 필요한 nidx만 받아온다. 페이지가 hidden type으로든 데이터를 가지고 있어야 할듯
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO vo = new NoticeVO();
		vo.setNidx(Integer.parseInt(request.getParameter("nidx")));
		ActionForward forward = null;
		
		// delete 문 정상 수행시 삭제 후 다시 notice.not로 오류시 alert 창 이후 다시 삭제할 수 있는 페이지로
		if(dao.deleteNotice(vo)) {
			forward = new ActionForward();
			forward.setPath("notice.not");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('오류! 공지사항 삭제에 실패했습니다.');history.go(-1);</script>");
		}
		return forward;
	}

}
