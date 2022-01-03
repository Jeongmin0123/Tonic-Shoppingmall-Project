package controller.contact;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.contact.ContactDAO;
import model.contact.ContactVO;

public class ContactSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 검색어에 해당하는 데이터를 cdatas로 준비한다.
		ContactDAO dao = ContactDAO.getInstance();
		String searchword = request.getParameter("searchword");
		ArrayList<ContactVO> cdatas = dao.searchContact(searchword);
		ActionForward forward = null;
		
		// 검색어에 해당하는 문의가 존재할 경우 request의 cdatas에 cdatas를 저장한 뒤에 다시 contact.jsp로 이동한다.
		// 만약 없을 시에 alert 창으로 해당 문의가 없다 말하고 다시 contact.jsp로 이동한다.
		if(cdatas != null) {
			request.setAttribute("cdatas", cdatas);
			forward = new ActionForward();
			forward.setPath("contact.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('검색어에 해당하는 문의가 존재하지 않습니다.');history.go(-1);</script>");
		}
		return forward;
	}

}
