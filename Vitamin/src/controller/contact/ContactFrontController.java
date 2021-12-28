package controller.contact;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.ActionForward;
import controller.notice.NoticeAction;

/**
 * Servlet implementation class ContactFrontController
 */
@WebServlet("/ContactFrontController")
public class ContactFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request,response);
	}
	private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파악을 위해 uri 가져오기
		String uri=request.getRequestURI();
		System.out.println(uri);
		String cp=request.getContextPath();
		System.out.println(cp);
		String command=uri.substring(cp.length());
		System.out.println(command);
		
		ActionForward forward=null;
		if(command.equals("/contact.con")) {		// main 페이지에서 문의하기 누르면 문의하기 page로 넘어가는 부분, contact.con 을 통해 contact.jsp로 이동!
			try {
				forward= new ContactAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/contact_detail.con")) {		// 관리자가 contact.jsp 에서 번호를 누르거나 세부 보기를 누르면 contact_detail.con을 지나 contact_detail.jsp 로 이동!
			try {
				forward= new ContactDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/contact_insert.con")) {		// 회원이 문의사항 등록을 누르면 실행되는 부분, contact_insert.con을 지나 잘 insert 되면 contact.con 을 통해 contact.jsp로 이동!, 안되면 alert 창
			try {
				forward= new ContactWriteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/contact_delete.con")) {		// 관리자 혹은 회원이 문의사항 삭제를 누르면 시행되는 부분, contact_delete.con을 지나 잘 삭제되면 contact.jsp로 다시 감.
			try {
				forward= new ContactDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/contact_admin.con")) {		// 관리자가 문의사항을 전체를 볼 수 있는 페이지, 페이지 추가가 필요해보임.
			try {
				forward= new ContactAdminAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward!=null) { 
			if(forward.isRedirect()) { 
				response.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}

}
