package controller.product;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Delete를 위한 기본 정보 불러오기
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO vo = new ProductVO();
		vo.setPno(request.getParameter("pno"));
		ActionForward forward = null;
		// 상품 삭제 성공시 삭제 후 다시 manage.jsp 페이지로 이동, 실패시 alert 창 이후 전페이지로 이동
		if(dao.deleteProduct(vo)) {
			forward = new ActionForward();
			forward.setPath("manage.jsp");
			forward.setRedirect(false);
		} else {
			response.setContentType("text/html; charset=UTF-8"); 
			PrintWriter out = response.getWriter();
			out.println("<script>alert('등록상품 삭제에 실패했습니다! 권한이 주어져있는지 확인해보세요!');history.go(-1);</script>");
		}
		return forward;
	}

}
