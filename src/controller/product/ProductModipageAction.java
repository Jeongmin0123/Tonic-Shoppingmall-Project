package controller.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductModipageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// id 값을 통해서 상품의 전체 데이터를 불러온다.
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO vo = new ProductVO();
		vo.setPno(request.getParameter("pno"));
		ProductVO pdata = dao.selectOne(vo);
		ActionForward forward = null;
		// 불러온 전체 데이터를 pdata에 저장한 뒤에 product_modi.jsp로 이동한다.
		if(pdata != null) {
			request.setAttribute("pdata", pdata);
			forward = new ActionForward();
			forward.setPath("product_modi.jsp");
			forward.setRedirect(false);
		} else {
			// 실패시 alert 창 이후 전 페이지로 이동
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('상품수정으로 이동이 불가능합니다. 다시 확인해보세요!');history.go(-1);</script>");
		}
		
		return forward;
		
	}

}