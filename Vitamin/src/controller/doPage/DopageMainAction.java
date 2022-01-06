package controller.doPage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class DopageMainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ProductDAO dao = ProductDAO.getInstance();
		// 상품 전체 데이터를 pdatas, 정렬된 데이터를 pdatas_ + 정렬방식 순으로 만든다.
		ArrayList<ProductVO> pdatas = dao.selectAllTOP6();
		request.setAttribute("pdatas", pdatas);
		
		ArrayList<ProductVO> pdatas_high = dao.selectAllHigh6();
		request.setAttribute("pdatas_high", pdatas_high);
		
		ArrayList<ProductVO> pdatas_low = dao.selectAllLow6();
		request.setAttribute("pdatas_low", pdatas_low);
		
		ArrayList<ProductVO> pdatas_soldout = dao.sql_selectAlmostSoldOut6();
		request.setAttribute("pdatas_soldout", pdatas_soldout);
	
		ActionForward forward = new ActionForward();
		forward.setPath("main.jsp");
		forward.setRedirect(false);
		return forward;
	}

}