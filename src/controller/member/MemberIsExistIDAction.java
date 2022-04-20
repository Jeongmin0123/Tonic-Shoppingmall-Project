package controller.member;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.member.MemberDAO;

public class MemberIsExistIDAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 이 부분은 보시고 피드백 해주세요!
		System.out.println("여기까지 들어오는지");
		String mid = request.getParameter("mid");
		MemberDAO dao = MemberDAO.getInstance();
		PrintWriter out = response.getWriter();
		int result;
		if(dao.isExistID(mid)) {
			result = 0;
			System.out.println("이미 존재하는 아이디입니다.");
		} else {
			result = 1;
			System.out.println("사용 가능한 아이디입니다.");
		}
		out.write(result + "");
		return null;
	}

}
