package controller.product;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.common.ActionForward;
import controller.notice.NoticeAction;

/**
 * Servlet implementation class ProductFrontController
 */
@WebServlet("/ProductFrontController")
public class ProductFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDO(request,response);
	}
	private void actionDO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 파악을 위해 uri 가져오기
		String uri=request.getRequestURI();
		System.out.println(uri);
		String cp=request.getContextPath();
		System.out.println(cp);
		String command=uri.substring(cp.length());
		System.out.println(command);
		
		ActionForward forward=null;
		if(command.equals("/product_selectall.pro")) {		// main 페이지 위의 호버 등에서 전체상품 보기를 누를 경우 product의 전체 데이터들을 가지고 shop_grid.jsp 페이지로 이동
			try {
				forward= new ProductSelectAllAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_detail.pro")) {		// 상품 분류별 페이지 등에서 상품 이미지나 상품명을 눌렀을 경우 상품의 pno를 받아와 그를 토대로 상품의 세부정보를 받아 shop_detail 페이지로 이동
			try {
				forward= new ProductDetailAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_delete.pro")) {		// manage.jsp 페이지에서 삭제버튼 클릭 시 삭제 후에 다시 manage.jsp페이지로 이동		
			try {
				forward= new ProductDeleteAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_manage.pro")) {		// 관리자만 보이는 main 페이지의 상품관리 page에 들어갈 경우 가지고 있는 모든 상품정보를 가지고 manage.jsp페이지로 이동
			try {
				forward= new ProductManageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_filterselect.pro")) {		// main 페이지에서 종합비타민, 유산균, 눈 영양제를 눌렀을 경우 이를 토대로 필터를 통하여 원하는 데이터만 불러와 shop_grid 페이지로 이동
			try {
				forward= new ProductPcodeFilterAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_search.pro")) {		// 모든 페이지의 검색창에 검색어를 넣고 검색을 누르면 그 검색어를 통하여 데이터를 불러온 후에 shop_grid.jsp에 그 데이터를 넘겨주면서 이동한다.
			try {
				forward= new ProductSearchAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_selectallhigh.pro")) {		// shop_grid 페이지에서 높은가격순을 누르면 높은가격순서대로 상품을 pdatas로 저장한 후에 이 데이터들을 가지고 shop_grid.jsp로 이동한다.
			try {
				forward= new ProductSelectAllHighAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_selectalllow.pro")) {		// shop_grid 페이지에서 낮은가격순을 누르면 낮은가격순서대로 상품을 pdatas로 저장한 후에 이 데이터들을 가지고 shop_grid.jsp로 이동한다.
			try {
				forward= new ProductSelectAllLowAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_selectallname.pro")) {		// shop_grid 페이지에서 이름순을 누르면 이름순서대로 상품을 pdatas로 저장한 후에 이 데이터들을 가지고 shop_grid.jsp로 이동한다.
			try {
				forward= new ProductSelectAllNameAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_update.pro")) {		// product_modi.jsp 페이지에서 상품 수정이라는 버튼을 누를 시에 DB의 내용이 수정되는 부분. product_mamage.pro 를 통해 다시 manage.jsp 로 이동
			try {
				forward= new ProductUpdateAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_insert.pro")) {		// register.jsp에서 상품등록 버튼을 누르면 상품등록 이후에 다시 register.jsp로 이동 
			try {
				forward= new ProductInsertAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_cartin.pro")) {		// 상품 세부 페이지에서 장바구니 버튼을 클릭 시에 id값을 통해서 전체 값을 받아준 뒤에 카트에 그 데이터를 저장하고 다시 product_detail.pro를 통해 shop_detail.jsp로 이동
			try {
				forward= new ProductCartInAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/product_modi.pro")) {		// manage.jsp 페이지에서 상품 수정을 위해서 수정 버튼을 누르면 데이터를 가지고 상품수정을 위한 product_modi.jsp 페이지로 이동
			try {
				forward= new ProductModipageAction().execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(forward!=null) { 
			if(forward.isRedirect()) { 
				response.sendRedirect(forward.getPath());
			}
			else {
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
}
