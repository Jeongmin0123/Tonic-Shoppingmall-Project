package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.common.JDBCUtil;

public class ProductDAO {
	private ProductDAO(){}
	private static ProductDAO ProductIns = new ProductDAO();
	public static ProductDAO getInstance() {return ProductIns;}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private	String sql_insertP = "INSERT INTO product VALUES(LPAD(prod_seq.NEXTVAL, 2, 0),"
			+ "?,?,?,?,?,?,?,?,?,?)";
	private	String sql_selectAll = "SELECT * FROM product ORDER BY prod_code";
//  (상품코드, 상품분류코드, 상품명, 가격, 정보, 유통기간, 제조일자, 원산지, 제조업체, 판매량, 재고량)

	
//  상품등록
//  크롤링하게 되면 MultipartRequest 라이브러리를 설치할 필요가 없다. 데이터 초기화
//	MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, ···());
	public boolean insertProduct(/* MultiparRequest multi */) { // (MultipartRequest multi) || (HttpServletRequest request)
	//	String upload = "C:/Users/ ···";
		int result = 0;
		con = JDBCUtil.connect();
		try {
			String prod_class = getParameter("");
			String prod_class = getParameter("");
			String prod_class = getParameter("pname");
			String prod_class = getParameter("pname");
			
			
			pstmt = con.prepareStatement(sql_insertP);
			pstmt.setString(1, product.getProd_class());
			pstmt.setString(2, product.getProd_name());
			pstmt.setInt(3, product.getProd_price());
			pstmt.setString(4, product.getProd_detail());
			pstmt.setString(5, product.getProd_period());
			pstmt.setString(6, product.getProd_date());
			pstmt.setString(7, product.getProd_origin());
			pstmt.setString(8, product.getProd_manuf());
			pstmt.setInt(9, product.getProd_sales());
			pstmt.setInt(10, product.getProd_stock());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("MemberDAO insertMember() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
//  상품조회
//  private	String sql_selectAll = "SELECT * FROM product ORDER BY prod_code";
	public ArrayList<ProductVO> selectAll() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setProd_code(rs.getInt("prod_code"));
				product.setProd_class(rs.getString("prod_class"));
				product.setProd_name(rs.getString("prod_name"));
				product.setProd_price(rs.getInt("prod_price"));
				product.setProd_detail(rs.getString("prod_detail"));
				product.setProd_period(rs.getString("prod_period"));
				product.setProd_date(rs.getString("prod_date"));
				product.setProd_origin(rs.getString("prod_origin"));
				product.setProd_manuf(rs.getString("prod_manuf"));
				product.setProd_sales(rs.getInt("prod_sales"));
				product.setProd_stock(rs.getInt("prod_stock"));
				
				plist.add(product);
			}
		} catch(Exception e) {
			System.out.println("MemberDAO selectAll() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
}
