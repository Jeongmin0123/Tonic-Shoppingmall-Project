package controller.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// DAO를 통해서 자바 클래스 내에 pdata란 이름으로 상품세부 정보 불러오기
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO vo = new ProductVO();
		vo.setPno(request.getParameter("pno"));
		ProductVO pdata = dao.selectOne(vo);
		ActionForward forward = null;
		
		// 상품 정보가 잘 불러와져서 pdata에 null값이 안 들어갔다면 View가 보여줄 pdata에 불러온 상품정보 넣기
		if(pdata != null) {
			request.setAttribute("pdata", pdata);
			forward = new ActionForward();
			forward.setPath("shop_detail.jsp");
			forward.setRedirect(false);
		} else {
			// 실패시 alert 창 이후 전 페이지로 이동
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('상품세부정보 불러오기에 실패했습니다.');history.go(-1);</script>");
		}
		
		return forward;
	}

}
