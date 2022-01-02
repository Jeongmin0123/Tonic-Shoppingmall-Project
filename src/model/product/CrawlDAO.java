package model.product;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import model.common.JDBCUtil;
public class CrawlDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 비타민
	public static void insertVITA() {
		Connection con = null;
		PreparedStatement pstmt = null;
		 
		// SQL 수정
		String sql_insert = "INSERT INTO prod VALUES (LPAD(PROD_SEQ.NEXTVAL,2,0), ?, ?, ?, ?, ?)";
		String url = "https://www.uppear.co.kr/goods/goods_list.php?page=1&cateCd=003005&sort=&pageNum=40";
//		비타민 : https://www.uppear.co.kr/goods/goods_list.php?page=1&cateCd=003005&sort=&pageNum=40
//		유산균 : https://www.uppear.co.kr/goods/goods_list.php?cateCd=003001
//		눈건강 : https://www.uppear.co.kr/goods/goods_list.php?cateCd=003015
		try {
//			pstmt = con.prepareStatement(sql_insert);
			int cnt = 0;
			
			Document doc = Jsoup.connect(url).get(); // url의 HTML 코드를 가져온다.
			Elements ele = doc.select("div.goods_list_cont"); // 그 중 div의 item_cont 클래스 태그로 둘러쌓인 부분을 가져온다. 
/*			Elements brand = doc.select("span.item_brand");
			Elements name = doc.select("strong.item_name");
			Elements price = doc.select("strong.item_price");
			Elements discount = doc.select("span.discount-rate");
			Elements image = doc.select("div.item_photo_box > a > img"); 
			for(int i = 0; i < 40; i++) {
				if(brand.get(i).text() != null) {
					System.out.println("브랜드 : " + brand.get(i).text()); 
				} else {
					System.out.println("브랜드 :  ★★★★★★★★★★★★★★★★★★★★★★"); 
				}
				System.out.println("상품명 : " + name.get(i).text());
				System.out.println("가격 : " + price.get(i).text());
				if(discount.get(i).text() != null) {
					System.out.println("할인율 : " + discount.get(i).text());
				} else {
					System.out.println("할인율 :  ★★★★★★★★★★★★★★★★★★★★★★"); 
				}
				System.out.println("이미지 : " + image.get(i).attr("abs:src"));
				cnt++; System.out.println("" + cnt);
			} */
			
//			Iterator<Element> itr_brand = ele.select("span.item_brand").iterator();
			Iterator<Element> itr = ele.select("div.item_basket_type > ul > li").iterator(); // NoSuchElementException 에러 발생
			Iterator<Element> itr_brand = ele.select("span.item_brand").iterator(); // NoSuchElementException 에러 발생
			Iterator<Element> itr_name = ele.select("strong.item_name").iterator(); // 정상
			Iterator<Element> itr_price = ele.select("strong.item_price").iterator(); // 정상
			Iterator<Element> itr_discount = ele.select("span.discount-rate").iterator(); // 정상
			Iterator<Element> itr_img_src = ele.select("div.item_photo_box > a > img").iterator(); // 정상
//			Iterator<Element> itr_img_src = ele.select("img.middle").iterator(); // 어피어배송, 해외배송 img src까지 출력
			while(itr_name.hasNext()) {
				try {
					System.out.println("브랜드 : " + itr_brand.next().text()); 
				} catch(Exception e) {
					System.out.println("브랜드 :  ＠＠＠＠＠＠＠＠＠＠＠＠＠ "); 
					e.printStackTrace();
				}
				System.out.println("상품명 : " + itr_name.next().text()); 
				System.out.println("가격 : " + itr_price.next().text());
				try {
					System.out.println("할인율 : " + itr_discount.next().text());
				} catch(Exception e) {
					System.out.println("할인율 :  ★★★★★★★★★★★★★★ "); 
					e.printStackTrace();
				}
				System.out.println("이미지 절대경로 : " + itr_img_src.next().attr("abs:src")); // src | abs:src = src의 절대 경로
				cnt++; System.out.println("" + cnt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("종결"); 
		}
	}
}
