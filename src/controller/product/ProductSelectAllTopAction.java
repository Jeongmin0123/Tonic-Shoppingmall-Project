package controller.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductSelectAllTopAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 상품 데이터를 판매량 순으로 정렬한다.
		ProductDAO dao = ProductDAO.getInstance();
		ArrayList<ProductVO> pdatas = dao.selectAllTOP();
		request.setAttribute("pdatas", pdatas);

		// shop_grid.jsp에서 가격순으로 보기를 누른 경우 정렬된 데이터들 가지고 바로 shop_grid 페이지로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("shop_grid.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
