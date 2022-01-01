package model.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// import javax.servlet.http.HttpServletRequest;

// import com.oreilly.servlet.MultipartRequest;
// import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.common.JDBCUtil;
import model.notice.NoticeVO;

public class ProductDAO {
	private ProductDAO(){}
	private static ProductDAO ProductIns = new ProductDAO();
	public static ProductDAO getInstance() {return ProductIns;}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

//  상품테이블(상품번호, 상품분류, 이미지 절대경로, 브랜드, 상품명, (할인된)가격, 할인율, 원산지, 유통기한, 판매량, 재고량)
	private	String sql_insertP = "INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdiscount, porigin, pperiod, psales, pstock) \r\n" + 
			"VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), ?, ?, ?, ?, ?, '0%',\r\n" + 
			"DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1, '국내산', 2, '중국산', 3, '미국산', 4, '대만산', 5, '일본산', 6, '독일산', 7, '파푸아뉴기니산'),\r\n" + 
			"DECODE(ROUND(DBMS_RANDOM.VALUE(1, 7)),1,'2022년 4월',2,'2022년 9월',3,'2022년 12월',4,'2023년 5월',5,'2023년 7월',6,'2023년 11월',7,'이미 썩었음'),\r\n" + 
			"ROUND(DBMS_RANDOM.VALUE(1, 200)), ROUND(DBMS_RANDOM.VALUE(1, 200)))";
//	private	String sql_updateP = "UPDATE product SET pname=?, pprice=?,  WHERE pno=?"; // 220101 미구현
	private	String sql_selectAll = "SELECT * FROM product ORDER BY pno DESC";
	private	String sql_selectOne = "SELECT * FROM product WHERE pno = ?";
	private	String sql_deleteP = "DELETE FROM product WHERE pno = ?";
	private String sql_filterPcode = "SELECT * FROM product WHERE pcode = ?"; // 상품분류 기반 필터 쿼리
	private String sql_searchPname = "SELECT * FROM product WHERE pname LIKE '%'||?||'%'"; // 상품명 기반 검색 쿼리

	// 상품등록 폼 파일 업로드 구현 -> MultipartRequest 라이브러리를 설치할 필요 有
	// MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
	// MultipartRequest(객체, 저장될 서버 경로, 파일 최대 크기, 인코딩 방식, 같은 이름의 파일명 방지 처리)

	// 상품등록(아직 수정 중입니다)
	public boolean insertProduct(HttpServletRequest request) throws IOException { 
		int result = 0;
		
		// String uploadURL = "절대경로";, 각 컴퓨터마다 경로가 다르기 때문에 수정해야 합니다.
		String dir = "C:\\Users\\totls\\git\\Tonic-Shoppingmall-Project\\WebContent\\getImg"; 
		int Size = 100*1024*1024; // 받아올 파일용량 제한 : 100MB
		MultipartRequest multi = new MultipartRequest(request, dir, Size, "UTF-8", new DefaultFileRenamePolicy());
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertP);
			pstmt.setString(1, multi.getParameter("pcode"));
			if(multi.getFilesystemName("pimg_src") != null) 
				{ pstmt.setString(2, multi.getFilesystemName("pimg_src")); }
			pstmt.setString(3, multi.getParameter("pbrand"));
			pstmt.setString(4, multi.getParameter("pname"));
			pstmt.setString(5, multi.getParameter("pprice"));
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
			pstmt = con.prepareStatement(sql_selectAll); // 수정
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPno(rs.getString("pno"));
				product.setPcode(rs.getString("pcode"));
				product.setPimg_src(rs.getString("pimg_src"));
				product.setPbrand(rs.getString("pbrand"));
				product.setPname(rs.getString("pname"));
				product.setPprice(rs.getInt("pprice"));
				product.setPdiscount(rs.getString("pdiscount"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPorigin(rs.getString("porigin"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
				
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
		ProductVO product = new ProductVO();
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectOne);
			pstmt.setString(1, vo.getPno());
			rs = pstmt.executeQuery();
			if(rs.next()) {
				product.setPno(rs.getString("pno"));
				product.setPcode(rs.getString("pcode"));
				product.setPimg_src(rs.getString("pimg_src"));
				product.setPbrand(rs.getString("pbrand"));
				product.setPname(rs.getString("pname"));
				product.setPprice(rs.getInt("pprice"));
				product.setPdiscount(rs.getString("pdiscount"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPorigin(rs.getString("porigin"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
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
			pstmt.setString(1, vo.getPno());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("MemberDAO deleteProduct() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result == 1; 
	}

	// 상품분류 필터  메서드
	// sql_filterPcode = "SELECT * FROM product WHERE pcode LIKE '%'||?||'%'";
	public ArrayList<ProductVO> filterProductCode(String searchPcode) { 
		ArrayList<ProductVO> plist = new ArrayList<>();
		ProductVO product = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_filterPcode);
			pstmt.setString(1, searchPcode);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product.setPno(rs.getString("pno"));
				product.setPcode(rs.getString("pcode"));
				product.setPimg_src(rs.getString("pimg_src"));
				product.setPbrand(rs.getString("pbrand"));
				product.setPname(rs.getString("pname"));
				product.setPprice(rs.getInt("pprice"));
				product.setPdiscount(rs.getString("pdiscount"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPorigin(rs.getString("porigin"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
				
				plist.add(product);
			}
		} catch(SQLException e) {
			System.out.println("ProductDAO searchProductCode(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	
	// 상품명 검색  메서드
	// sql_searchPname = "SELECT * FROM product WHERE pname LIKE '%'||?||'%'";
	public ArrayList<ProductVO> searchProductCode(String searchPname) { 
		ArrayList<ProductVO> plist = new ArrayList<>();
		ProductVO product = null;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_searchPname);
			if(searchPname != null && !searchPname.equals("") && !searchPname.equals(" ")) {
				pstmt.setString(1, searchPname.trim());
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				product.setPno(rs.getString("pno"));
				product.setPcode(rs.getString("pcode"));
				product.setPimg_src(rs.getString("pimg_src"));
				product.setPbrand(rs.getString("pbrand"));
				product.setPname(rs.getString("pname"));
				product.setPprice(rs.getInt("pprice"));
				product.setPdiscount(rs.getString("pdiscount"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPorigin(rs.getString("porigin"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
				
				plist.add(product);
			}
		} catch(SQLException e) {
			System.out.println("ProductDAO searchProductCode(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
}
