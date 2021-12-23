package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
//  (상품코드, 상품분류코드, 상품명, 가격, 정보, 유통기간, 제조일자, 원산지, 제조업체, 판매량, 재고량)

	
//  상품등록 
	public boolean insertProduct(ProductVO product) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
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
			System.out.println("MemberDAO insertMember() 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
}
