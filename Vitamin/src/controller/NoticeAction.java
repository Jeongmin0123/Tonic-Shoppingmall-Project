package controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		NoticeDAO dao = new NoticeDAO();
//		int count = Integer.parseInt(request.getParameter("count"));
//		ArrayList<NoticeVO> datas=dao.selectAll(count);	// noticeSet의 존재 이유???
//		request.setAttribute("datas", datas);
//		return null;
//		
		ActionForward forward = new ActionForward();
//		forward.setPath("notice.jsp");	// 어디로 가야하는지 : 경로
//		forward.setRedirect(false);		// 어떻게 가야하는지 : 방식
		return forward;
	}

}
