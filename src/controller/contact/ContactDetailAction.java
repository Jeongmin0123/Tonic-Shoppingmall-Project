package controller.contact;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.contact.ContactDAO;
import model.contact.ContactVO;

public class ContactDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ContactDAO dao = ContactDAO.getInstance();
		ContactVO vo = new ContactVO();
		vo.setMsgno(Integer.parseInt(request.getParameter("msgno")));
		ContactVO cdata = dao.selectOne(vo);
		ActionForward forward = null;
		
		if(cdata != null) {
			request.setAttribute("cdata", cdata);
			forward = new ActionForward();
			forward.setPath("contact_detail.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('문의사항 불러오기에 실패했습니다.');history.go(-1);</script>");
		}
		return forward;
	}

}
