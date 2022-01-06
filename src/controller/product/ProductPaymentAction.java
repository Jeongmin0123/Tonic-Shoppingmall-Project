package controller.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;

public class ProductPaymentAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 결제 부분도 얘기 이후 수정예정
		// alert 창 제공
		PrintWriter out = response.getWriter();
		out.println("<script>alert('결제가 완료되었습니다!');</script>");
		
		// cart_datas 로 저장된 장바구니 데이터를 삭제
		HttpSession session = request.getSession();
		session.removeAttribute("cart_datas");
		
		ActionForward forward = new ActionForward();
		forward.setPath("main.do");
		forward.setRedirect(false);
		return forward;
	}

}
