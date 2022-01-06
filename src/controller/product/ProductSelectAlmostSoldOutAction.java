package controller.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductSelectAlmostSoldOutAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 모든 상품 데이터들을 이름순으로 pdatas 라는 이름으로 저장
		ProductDAO dao = ProductDAO.getInstance();
		ArrayList<ProductVO> pdatas = dao.sql_selectAlmostSoldOut();
		request.setAttribute("pdatas", pdatas);
				
		// shop_grid.jsp에서 가격순으로 보기를 누른 경우 정렬된 데이터들 가지고 바로 shop_grid 페이지로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("shop_grid.jsp");
		forward.setRedirect(false);
		return forward;
	}
}
