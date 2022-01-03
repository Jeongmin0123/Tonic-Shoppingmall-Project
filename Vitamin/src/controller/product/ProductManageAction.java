package controller.product;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductManageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 모든 상품 데이터들을 pdatas 라는 이름으로 저장
		ProductDAO dao = ProductDAO.getInstance();
		ArrayList<ProductVO> pdatas = dao.selectAll();
		System.out.println(pdatas);
		request.setAttribute("pdatas", pdatas);
				
		// 상품관리를 누른 경우 위 데이터들을 가지고 바로 manage.jsp 페이지로 이동
		ActionForward forward = new ActionForward();
		forward.setPath("manage.jsp");
		forward.setRedirect(false);
		return forward;		
	}

}
