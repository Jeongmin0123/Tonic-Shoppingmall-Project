package controller.product;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductSearchAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 검색 단어는 searchword 로 받아오고 그 searchword를 토대로 상품리스트를 pdatas로 받는다.
		ProductDAO dao = ProductDAO.getInstance();
		String searchword = request.getParameter("searchword");
		System.out.println(searchword);
		ArrayList<ProductVO> pdatas = dao.searchProductName(searchword);
		ActionForward forward = null;

		if(pdatas != null) {
			// 검색 조건에 해당하는 상품이 있어서 pdatas를 상품데이터로 가져오면 request의 pdatas에 이 상품들을 세팅하고 shop_grid.jsp로 보낸다.
			request.setAttribute("pdatas", pdatas);
			forward = new ActionForward();
			forward.setPath("shop_grid.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('검색어에 해당하는 상품이 존재하지 않습니다.');history.go(-1);</script>");
		}
		return forward;
	}

}
