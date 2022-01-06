package controller.product;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.common.Action;
import controller.common.ActionForward;
import model.product.ProductDAO;
import model.product.ProductVO;

public class ProductCartInAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 먼저 장바구니에 들어갈 데이터를 dao.selectOne으로 준비
		ProductDAO dao = ProductDAO.getInstance();
		ProductVO vo = new ProductVO();
		vo.setPno(request.getParameter("pno"));
		ProductVO cart_data = dao.selectOne(vo);
		
		// 장바구니 리스트를 준비
		HttpSession session=request.getSession();		
		ArrayList<ProductVO> cart_datas = (ArrayList<ProductVO>) session.getAttribute("cart_datas");
		
		// 만약 장바구니에 아무 정보가 없을 시에 장바구니를 새로 생성
		if(session.getAttribute("cart_datas") == null) {
			cart_datas = new ArrayList<ProductVO>();
		}
		PrintWriter out = response.getWriter();
		ActionForward forward = null;
		// 로그인이 되었을 시에 생성된 장바구니에 들어갈 데이터를 저장
		if(session.getAttribute("mid") != null) {
			cart_datas.add(cart_data);
			session.setAttribute("cart_datas", cart_datas);
			out.println("<script>alert('장바구니에 상품이 추가되었습니다!');history.go(-1);</script>");	
		} else {
			forward = new ActionForward();
			forward.setPath("login.jsp");
			forward.setRedirect(false);
		}
		 
		return forward;
	}

}
