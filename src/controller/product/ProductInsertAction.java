package controller.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 입력받는 인자가 request이므로 따로 필요한 객체가 없음
		ProductDAO dao = ProductDAO.getInstance();
		ActionForward forward = null;
		// insert가 잘 수행되면 register.jsp로 안되면 alert창 이후 전페이지로 이동
		if(dao.insertProduct(request)) {
			forward = new ActionForward();
			forward.setPath("product_manage.pro");
			forward.setRedirect(true);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('상품등록에 실패하였습니다! 입력값을 확인하세요!');history.go(-1);</script>");
		}
		return forward;
	}
	
}
