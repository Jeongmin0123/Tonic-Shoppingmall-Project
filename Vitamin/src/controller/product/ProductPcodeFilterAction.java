package controller.product;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductPcodeFilterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDAO dao = ProductDAO.getInstance();
		// View에서 종합비타민, 눈 영양제 등을 누를떄 가져오는 파라미터를 pcode라 함
		String pcode = request.getParameter("pcode");
		// pcode를 통하여 코드에 맞는 상품들을 pdatas로 불러옴
		ArrayList<ProductVO> pdatas = dao.filterProductCode(pcode);
		ActionForward forward = null;
		if(pdatas != null) {
			// 주어진 데이터를 request의 pdatas에 저장하고 shop_grid.jsp 페이지로 이동한다.
			request.setAttribute("pdatas", pdatas);
			forward = new ActionForward();
			forward.setPath("shop_grid.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('분류별 상품 불러오기에 실패했습니다.');history.go(-1);</script>");
		}
		return forward;
	}

}
