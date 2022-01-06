package model.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



import model.common.JDBCUtil;

public class ProductDAO {
	private ProductDAO(){}
	private static ProductDAO ProductIns = new ProductDAO();
	public static ProductDAO getInstance() {return ProductIns;}
	
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

//  상품테이블(상품번호, 상품분류, 이미지 절대경로, 브랜드, 상품명, 가격, 할인율, 원산지, 유통기한, 판매량, 재고량)
//  상품등록 시 입력받는 것들 = 이미지(파일 업로드), 분류, 브랜드, 상품명, 가격, 상세정보, 원산지, 유통기한, 재고량}
	private	String sql_insertP = "INSERT INTO product(pno, pcode, pimg_src, pbrand, pname, pprice, pdetail, porigin, pperiod, pstock) " + 
			"VALUES(LPAD(PROD_SEQ.NEXTVAL, 3, 0), ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private	String sql_updateP = "UPDATE product SET pcode=?, pimg_src=?, pbrand=?, pname=?, pprice=?, pdetail=?, porigin=?, pperiod=?, pstock=? WHERE pno=?"; 
	private	String sql_selectAll = "SELECT * FROM product ORDER BY pno DESC";    

	private String sql_selectTOP = "SELECT * FROM product ORDER BY psales DESC"; // 판매인기순 
	private	String sql_selectAllHP = "SELECT * FROM product ORDER BY pprice DESC"; // 높은 가격순
	private	String sql_selectAllLP = "SELECT * FROM product ORDER BY pprice"; // 낮은 가격순
	private	String sql_selectAlmostSoldOut = "SELECT * FROM product ORDER BY pstock"; // 매진임박순
	
	private String sql_selectTOP6 = "SELECT * FROM (SELECT * FROM product ORDER BY psales DESC) WHERE ROWNUM <= 6"; // 판매인기순 TOP6
	private	String sql_selectAllHP6 = "SELECT * FROM (SELECT * FROM product ORDER BY pprice DESC) WHERE ROWNUM <=6"; // 높은 가격순 TOP6
	private	String sql_selectAllLP6 = "SELECT * FROM (SELECT * FROM product ORDER BY pprice) WHERE ROWNUM <=6"; // 낮은 가격순 TOP6
	private	String sql_selectAlmostSoldOut6 = "SELECT * FROM (SELECT * FROM product ORDER BY pstock) WHERE ROWNUM <=6"; // 매진임박순 TOP6
	
	private String sql_selectTOPPcode = "SELECT * FROM product WHERE pcode = ? ORDER BY psales DESC"; // 판매인기순 
	private	String sql_selectAllHPPcode = "SELECT * FROM product WHERE pcode = ? ORDER BY pprice DESC"; // 높은 가격순
	private	String sql_selectAllLPPcode = "SELECT * FROM product WHERE pcode = ? ORDER BY pprice"; // 낮은 가격순
	private	String sql_selectAlmostSoldOutPcode = "SELECT * FROM product WHERE pcode = ? ORDER BY pstock"; // 매진임박순
	
	private	String sql_selectOne = "SELECT * FROM product WHERE pno = ?";
	private	String sql_deleteP = "DELETE FROM product WHERE pno = ?";
	private String sql_filterPcode = "SELECT * FROM product WHERE pcode = ?"; // 상품분류 기반 필터 {VITA, LACT, EYES}
	private String sql_searchPname = "SELECT * FROM product WHERE pname LIKE '%'||?||'%'"; // 상품명 기반 검색 쿼리

//	상품등록 폼 파일 업로드 구현 -> MultipartRequest 라이브러리를 설치할 필요 有
//	MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
//	MultipartRequest(객체, 저장될 서버 경로, 파일 최대 크기, 인코딩 방식, 같은 이름의 파일명 방지 처리)
	// 상품등록
	public boolean insertProduct(HttpServletRequest request) throws IOException { 
		int result = 0;
		
//		String URL = "절대경로";, 각 컴퓨터마다 경로가 다르기 때문에 수정해야 합니다.
//		String dir = "C:\\Users\\totls\\git\\Tonic-Shoppingmall-Project\\WebContent\\getImg";
		String dir = request.getServletContext().getRealPath("/getImg"); // 실제경로를 가져온다.
		int Size = 100*1024*1024; // 받아올 파일용량 제한 : 100MB
		MultipartRequest multi = new MultipartRequest(request, dir, Size, "UTF-8", new DefaultFileRenamePolicy());
//		MultipartRequest(객체, 저장될 서버 경로, 파일 최대 크기, 인코딩 방식, 같은 이름의 파일명 방지 처리) 
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_insertP);
			pstmt.setString(1, multi.getParameter("pcode"));
			if(multi.getFilesystemName("pimg_src") != null) 
				{ pstmt.setString(2, multi.getFilesystemName("pimg_src")); }
			pstmt.setString(3, multi.getParameter("pbrand"));
			pstmt.setString(4, multi.getParameter("pname"));
			pstmt.setString(5, multi.getParameter("pprice"));
			pstmt.setString(6, multi.getParameter("pdetail"));
			pstmt.setString(7, multi.getParameter("porigin"));
			pstmt.setString(8, multi.getParameter("pperiod"));
			pstmt.setString(9, multi.getParameter("pstock"));
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("ProductDAO insertProduct() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
	}
	
	// 상품수정
	public boolean updateProduct(HttpServletRequest request) throws IOException {
		int result = 0;
		
		String dir = "C:\\Users\\totls\\git\\Tonic-Shoppingmall-Project\\WebContent\\getImg"; 
		int Size = 100*1024*1024; // 받아올 파일용량 제한 : 100MB
		MultipartRequest multi = new MultipartRequest(request, dir, Size, "UTF-8", new DefaultFileRenamePolicy());
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_updateP);
			pstmt.setString(1, multi.getParameter("pcode"));
			if(multi.getFilesystemName("pimg_src") != null) 
				{ pstmt.setString(2, multi.getFilesystemName("pimg_src")); }
			pstmt.setString(3, multi.getParameter("pbrand"));
			pstmt.setString(4, multi.getParameter("pname"));
			pstmt.setString(5, multi.getParameter("pprice"));
			pstmt.setString(6, multi.getParameter("pdetail"));
			pstmt.setString(6, multi.getParameter("porigin"));
			pstmt.setString(7, multi.getParameter("pperiod"));
			pstmt.setString(8, multi.getParameter("pstock"));
			pstmt.setString(9, multi.getParameter("pno")); // 음...
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("ProductDAO updateProduct(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(pstmt, con);
		}
		return result == 1;
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
				product.setPprice(rs.getInt("pprice")); // product.setPprice(rs.getInt("pprice"));
				product.setPdiscount(rs.getString("pdiscount"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPorigin(rs.getString("porigin"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
				
				plist.add(product);
			}
		} catch(Exception e) {
			System.out.println("ProductDAO selectAll() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
//  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 판매량
	public ArrayList<ProductVO> selectAllTOP() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectTOP); // 수정
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPno(rs.getString("pno"));
				product.setPcode(rs.getString("pcode"));
				product.setPimg_src(rs.getString("pimg_src"));
				product.setPbrand(rs.getString("pbrand"));
				product.setPname(rs.getString("pname"));
				product.setPprice(rs.getInt("pprice")); // product.setPprice(rs.getInt("pprice"));
				product.setPdiscount(rs.getString("pdiscount"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPorigin(rs.getString("porigin"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
				
				plist.add(product);
			}
		} catch(Exception e) {
			System.out.println("ProductDAO selectAllTOP() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	// 높은 가격순 
	public ArrayList<ProductVO> selectAllHigh() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAllHP); // 수정
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
			System.out.println("ProductDAO selectAllHigh() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	// 낮은 가격순
	public ArrayList<ProductVO> selectAllLow() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAllLP); // 수정
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
			System.out.println("ProductDAO selectAllLow() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}

	// 매진임박순
	public ArrayList<ProductVO> selectAlmostSoldOut() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAlmostSoldOut); // 수정
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
			System.out.println("ProductDAO selectAlmostSoldOut() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
//  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	// 판매량 TOP6
	public ArrayList<ProductVO> selectAllTOP6() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectTOP6); // 수정
			rs = pstmt.executeQuery();
			while(rs.next()) {
				ProductVO product = new ProductVO();
				product.setPno(rs.getString("pno"));
				product.setPcode(rs.getString("pcode"));
				product.setPimg_src(rs.getString("pimg_src"));
				product.setPbrand(rs.getString("pbrand"));
				product.setPname(rs.getString("pname"));
				product.setPprice(rs.getInt("pprice")); // product.setPprice(rs.getInt("pprice"));
				product.setPdiscount(rs.getString("pdiscount"));
				product.setPdetail(rs.getString("pdetail"));
				product.setPorigin(rs.getString("porigin"));
				product.setPperiod(rs.getString("pperiod"));
				product.setPsales(rs.getInt("psales"));
				product.setPstock(rs.getInt("pstock"));
				
				plist.add(product);
			}
		} catch(Exception e) {
			System.out.println("ProductDAO selectAllTOP6() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	// 높은 가격순  TOP6
	public ArrayList<ProductVO> selectAllHigh6() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAllHP6); // 수정
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
			System.out.println("ProductDAO selectAllHigh6() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	// 낮은 가격순 TOP6
	public ArrayList<ProductVO> selectAllLow6() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAllLP6); // 수정
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
			System.out.println("ProductDAO selectAllLow6() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	// 매진임박순 TOP6
	public ArrayList<ProductVO> selectAlmostSoldOut6() {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAlmostSoldOut6); // 수정
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
			System.out.println("ProductDAO selectAlmostSoldOut6() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	public ArrayList<ProductVO> selectTOPPcode(ProductVO vo) {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectTOPPcode);
			pstmt.setString(1, vo.getPcode());
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
			System.out.println("ProductDAO selectTOPPcode() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	
	public ArrayList<ProductVO> selectAllHPPcode(ProductVO vo) {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAllHPPcode);
			pstmt.setString(1, vo.getPcode());
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
			System.out.println("ProductDAO selectAllHPPcode() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	
	public ArrayList<ProductVO> selectAllLPPcode(ProductVO vo) {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAllLPPcode);
			pstmt.setString(1, vo.getPcode());
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
			System.out.println("ProductDAO selectAllLPPcode() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
	
	public ArrayList<ProductVO> selectAlmostSoldOutPcode(ProductVO vo) {
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_selectAlmostSoldOutPcode);
			pstmt.setString(1, vo.getPcode());
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
			System.out.println("ProductDAO selectAlmostSoldOutPcode() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
//  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
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
			System.out.println("ProductDAO selectOne() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return product;
	}
	//  상품삭제
	public boolean deleteProduct(ProductVO vo) {
		int result = 0;
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_deleteP);
			pstmt.setString(1, vo.getPno());
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("ProductDAO deleteProduct() : "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return result == 1; 
	}
	// 상품분류 필터  메서드
	public ArrayList<ProductVO> filterProductCode(ProductVO vo) { 
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_filterPcode);
			pstmt.setString(1, vo.getPcode());
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
		} catch(SQLException e) {
			System.out.println("ProductDAO filterProductCode(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
//  ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ	
	// 상품명 검색  메서드
	public ArrayList<ProductVO> searchProductName(String searchPname) { 
		ArrayList<ProductVO> plist = new ArrayList<>();
		
		con = JDBCUtil.connect();
		try {
			pstmt = con.prepareStatement(sql_searchPname);
			if(searchPname != null && !searchPname.equals("") && !searchPname.equals(" ")) {
				pstmt.setString(1, searchPname.trim());
			}
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
		} catch(SQLException e) {
			System.out.println("ProductDAO searchProductName(): "+ e +" 에러");
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(rs, pstmt, con);
		}
		return plist.isEmpty()? null : plist;
	}
}
