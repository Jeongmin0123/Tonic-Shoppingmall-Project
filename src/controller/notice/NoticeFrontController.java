package controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.ActionForward;

/**
 * Servlet implementation class NoticeFrontController
 */
@WebServlet("/NoticeFrontController")
public class NoticeFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeFrontController() {
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
		if(command.equals("notice.do")) {		// 회원으로 회원가입 시 필요한 부분 
			try {
				forward= new NoticeAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("notice_detail.no")) {
			try {
				forward= new NoticeDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("notice_insert.no")) {
			try {
				forward= new NoticeWriteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("notice_update.no")) {
			try {
				forward= new NoticeUpdateAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("notice_delete.no")) {
			try {
				forward= new NoticedeleteAction().execute(request, response);
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
