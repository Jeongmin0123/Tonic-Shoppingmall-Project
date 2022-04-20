package controller.product;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 입력받는 인자가 request이므로 따로 필요한 객체가 없음
		ProductDAO dao = ProductDAO.getInstance();
		ActionForward forward = null;
		
		System.out.println(request.getParameter("pno"));
		
		// update가 잘 수행되었을 시에 manage.jsp로 안되었을시에는 alert창 이후 전페이지로 이동한다.
		if(dao.updateProduct(request) ) {	
			ArrayList<ProductVO> pdatas = dao.selectAll();
			request.setAttribute("pdatas", pdatas);
			forward = new ActionForward();
			forward.setPath("manage.jsp");	//product_manage.pro
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('상품 수정에 실패했습니다. 입력내용을 확인해보세요!');history.go(-1);</script>");
		}
		
		return forward;
	}

}
