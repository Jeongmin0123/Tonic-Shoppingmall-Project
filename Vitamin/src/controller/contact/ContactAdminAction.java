package controller.contact;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.contact.ContactDAO;
import model.contact.ContactVO;
import model.notice.NoticeDAO;
import model.notice.NoticeVO;

public class ContactAdminAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// cdatas라는 이름에 contact data들을 arraylist 로 저장한다.
		ContactDAO dao = ContactDAO.getInstance();
		ArrayList<ContactVO> cdatas = dao.selectAll();
		request.setAttribute("cdatas", cdatas);
		
		// contact.jsp 파일로 이동할 수 있드록 경로를 지정하고 데이터를 기억해서 넘겨준다.
		ActionForward forward = new ActionForward();
		forward.setPath("contact_admin.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
