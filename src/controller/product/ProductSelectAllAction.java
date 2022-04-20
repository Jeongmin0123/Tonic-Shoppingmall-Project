package controller.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductSelectAllAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 모든 상품 데이터들을 pdatas 라는 이름으로 저장
		//System.out.println("상품분류페이지 "+request.getParameter("pcode"));
		ProductDAO dao = ProductDAO.getInstance();
		ArrayList<ProductVO> pdatas = dao.selectAll();
		
		request.setAttribute("pcode", request.getParameter("pcode"));
		request.setAttribute("pdatas", pdatas);
		
		// 전체상품 보기를 누른 경우 위 데이터들을 가지고 바로 shop_grid 페이지로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("shop_grid.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
