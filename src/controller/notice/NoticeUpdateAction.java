package controller.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 수정해서 입력한 내용들을 받아온 뒤에 update문 실행
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO vo = new NoticeVO();
		vo.setNtitle(request.getParameter("ntitle"));
		vo.setNcont(request.getParameter("ncont"));
		vo.setNidx(Integer.parseInt(request.getParameter("nidx")));
		ActionForward forward = null;
		
		// 수정이 잘 수행되면 다시 notice.not 을 통해 notice.jsp로 이동
		if(dao.updateNotice(vo)) {
			forward = new ActionForward();
			forward.setPath("notice.not");
			forward.setRedirect(false);
		} else {
			// 수정 실패시 alert 창 이후 다시 수정창으로 이동
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('공지사항 수정에 실패했습니다. 입력내용을 확인해보세요!');history.go(-1);</script>");
		}
		return forward;
	}

}
