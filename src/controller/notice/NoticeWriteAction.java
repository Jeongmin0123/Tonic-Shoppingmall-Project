package controller.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 관리자가 공지사항 작성을 누르면 작성된 공지사항이 DB에 등록된다
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO vo = new NoticeVO();
		vo.setNtitle(request.getParameter("ntitle"));
		vo.setNcont(request.getParameter("ncont"));
		vo.setWriter(request.getParameter("writer"));
		ActionForward forward = null;
		// 공지사항 작성이 잘 되면 작성후에 notice.do를 통해 notice.jsp로 이동한다.
		if(dao.insertNotice(vo)) {
			forward = new ActionForward();
			forward.setPath("notice.do");
			forward.setRedirect(false);	
		} else {
			// 작성 실패시 alert 창 이후 다시 작성페이지로 이동한다.
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('공지사항 작성에 실패했습니다. 내용을 확인해주세요.');history.go(-1);</script>");
		}
			
		return forward;
	}

}
