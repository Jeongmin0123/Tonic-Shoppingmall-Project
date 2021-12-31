package controller.notice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class NoticeSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 검색에 맞는 데이터만을 ndatas 로 설정한다.
		// view 확인해본 결과 아직 검색창 value로 가져올 값이 정해지지 않은 거 같아 search_word로 지정하였습니다.
		NoticeDAO dao = NoticeDAO.getInstance();
		String search_word = request.getParameter("search_word");
		ArrayList<NoticeVO> ndatas = dao.searchNotice(search_word);
		request.setAttribute("ndatas", ndatas);
		
		// 이미 여기서 검색에 맞는 ndatas를 설정했으므로 notice.not로 가지 않고 여기서 바로 notice.jsp로 간다.
		ActionForward forward = new ActionForward();
		forward.setPath("notice.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
