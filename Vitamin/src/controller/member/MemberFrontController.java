package controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/MemberFrontController")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberFrontController() {
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
		if(command.equals("/member_insert.mem")) {		// 회원가입 버튼을 누르면 수행되는 부분, 회원가입 페이지의 회원가입 폼 submit button의 action이 member_insert.mem이 되어야 함
			try {
				forward= new MemberInsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/member_delete.mem")) {		// 회원탈퇴 버튼을 누르면 수행되는 부분, 마이페이지의 회원탈퇴 버튼 submit의  action이 member_delete.mem 되어야 함
																// 회원탈퇴 시 아이디나 비밀번호를 입력해야 하는 form이나, 창, jsp 파일이 필요해보임
																// 그렇게 될시 member_delete.mem 과 mypage.jsp 사이에서 회원탈퇴 폼으로 이동시켜주는 컨트롤러가 하나 더 생길예정
			try {
				forward= new MemberDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/member_update.mem")) {		// 회원정보 수정 시 수행되는 부분, 마이페이지의 회원정보 수정 버튼의 submit action이 member_update.mem되어야 함
			try {
				forward= new MemberUpdateAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/member_login.mem")) {		//  로그인을 버튼을 누르면 수행되는 부분, 로그인 페이지의 로그인 버튼 submit action이 member_login.mem 되어야 함
			try {
				forward= new MemberLoginAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/isExistId.mem")) {	// 회원가입 시 아이디 중복여부 확인, ajax와 jquery로 구현예정, 컨트롤러 부분 미숙한 점 있으면 말해주세요!
			try {
				forward= new MemberIsExistIDAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/member_mypage.mem")) {	// 마이페이지로 가는 버튼을 누르면 수행되는 부분, 메인 페이지의 마이페이지 버튼 부분의 submit action이  member_mypage.mem 되어야 함
			try {
				forward= new MemberSelectAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/member_logout.mem")) {	// 로그아웃 버튼을 수행되는 부분, 메인 페이지의 로그아웃 버튼의 href가 member_logout.mem가 되어야 함
			try {
				forward= new MemberLogoutAction().execute(request, response);
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
