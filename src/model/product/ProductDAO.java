package model.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// import javax.servlet.http.HttpServletRequest;

// import com.oreilly.servlet.MultipartRequest;
// import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.common.JDBCUtil;

//  상품등록, 상품수정, 상품삭제
public class ProductDAO {
	private ProductDAO(){}
	private static ProductDAO ProductIns = new ProductDAO();
	public static ProductDAO getInstance() {return ProductIns;}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	private	String sql_insertP = "INSERT INTO product VALUES(LPAD(prod_seq.NEXTVAL, 2, 0),"
			+ " ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//  (상품코드, 상품분류코드, 상품명, 가격, 정보, 유통기간, 제조일자, 원산지, 제조업체, 판매량, 재고량)
//	private	String sql_updateP = "UPDATE product SET product WHERE pcode = ?";
	private	String sql_selectAll = "SELECT * FROM product ORDER BY pcode";
	private	String sql_selectOne = "SELECT * FROM product WHERE pcode = ?";
	private	String sql_deleteP = "DELETE FROM product WHERE pcode = ?";

	
/*	
상품등록 폼 파일 업로드 구현 -> MultipartRequest 라이브러리를 설치할 필요 有
MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
MultipartRequest(객체, 저장될 서버 경로, 파일 최대 크기, 인코딩 방식, 같은 이름의 파일명 방지 처리)
*/
	// 상품등록(아직 수정 중입니다)
	public boolean insertProduct(HttpServletRequest request) { // HttpServletRequest 빨간줄은 톰캣 서버를 연결하면 사라진다.
	//	String upload = "절대경로";
		String upload = "C:/···/···/···/WebContent/images";
		int limitSize = 50*1024*1024; // 50MB
		int result = 0;
		MultipartRequest multi = new MultipartRequest(request, upload, limitSize, "UTF-8", new DefaultFileRenamePolicy());
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertP);
			pstmt.setInt(1, multi.getParameter("pclass"));
			pstmt.setString(2, multi.getParameter("pname"));
			pstmt.setInt(3, multi.getParameter("pprice"));
			pstmt.setString(4, multi.getParameter("pdetail"));
			pstmt.setString(5, multi.getParameter("pperiod"));
			pstmt.setString(6, multi.getParameter("pdate"));
			pstmt.setString(7, multi.getParameter("porigin"));
			pstmt.setString(8, multi.getParameter("pmanuf"));
			pstmt.setInt(9, multi.getParameter("psales"));
			pstmt.setInt(10, multi.getParameter("pstock"));
			if(multi.getFilesystemName("pimage") != null) {
				pstmt.setInt(11, multi.getFilesystemName("pimage"));
			} else {
			//  pstmt.setString(11, "../images/폴더명");
			}
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("MemberDAO insertMember() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
	// 상품수정(수정 중입니다)
	public boolean updateProduct() {
		con = JDBCUtil.connect();
		try {
			
		} catch(Exception e) {
			
		} finally {
			
		}
		return false;
	}
	
	
	// 상품리스트 조회
	public ArrayList<ProductVO> selectAll() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAll);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPcode(rs.getInt("pcode"));
				product.setPclass(rs.getString("pclass"));
				product.setPname(rs.getString("pname"));
				product.setPprice(rs.getInt("pprice"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPdate(rs.getString("pdate"));
				product.setPorigin(rs.getString("porigin"));
				product.setPmanuf(rs.getString("pmanuf"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
				product.setPimage(rs.getString("pimage"));
				
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
	
	// 상품 본문조회
	public ProductVO selectOne(ProductVO vo) {
		ProductVO product = null;
		con = JDBCUtil.connect();
		
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setInt(1, vo.getPcode());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				product = new ProductVO();
				product.setPcode(rs.getInt("pcode"));
				product.setPclass(rs.getString("pclass"));
				product.setPname(rs.getString("pname"));
				product.setPprice(rs.getInt("pprice"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPdate(rs.getString("pdate"));
				product.setPorigin(rs.getString("porigin"));
				product.setPmanuf(rs.getString("pmanuf"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
				product.setPimage(rs.getString("pimage"));
			}
		} catch(Exception e) {
			System.out.println("MemberDAO selectOne() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return product;
	}

	//  상품삭제
	public boolean deleteProduct(ProductVO vo) {
	//  private	String sql_deleteP = "DELETE FROM product WHERE pcode = ?";
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_deleteP);
			pstmt.setInt(1, vo.getPcode());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("MemberDAO deleteProduct() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result == 1; 
	}
}
