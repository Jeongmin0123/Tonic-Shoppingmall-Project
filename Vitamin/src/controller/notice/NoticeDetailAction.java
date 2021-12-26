package controller.notice;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// nidx를 받아와서 vo에 설정해준 뒤 그 vo를 이용하여 ndata를 받는다.
//		NoticeDAO dao = NoticeDAO.getInstance();
//		NoticeVO vo = new NoticeVO();
//		vo.setNidx(Integer.parseInt(request.getParameter("nidx")));
//		NoticeVO ndata = new NoticeVO();
//		ndata = dao.selectOne(vo);
		ActionForward forward = null;
//		
//		// selectOne 문이 성공시 ndata에 세부 공지사항 저장 후 돌려주기
//		// 만약 실패시 alert 창 이후에 공지사항 페이지로 이동
//		if(ndata != null) {
//			request.setAttribute("ndata", ndata);
			forward = new ActionForward();
//			forward.setPath("notice_detail.jsp");
//			forward.setRedirect(false);	
//		} else {
//			response.setContentType("text/html; charset=UTF-8"); 
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('공지사항 불러오기에 실패했습니다.');history.go(-1);</script>");
//		}
//	
		return forward;
	}

}
