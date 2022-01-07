package model.product;

// import model.product.CrawlDAO;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CrawlEX {
	public static void main(String[] args) throws IOException {
		CrawlDAO.insertCrawlDB();
//		Crawl2();
	}
	
	// 막아놨습니다.
	// 무신사 발마칸 판매순, 크롤링이 안 되는데 robots.txt로 확인해보니 후 disallow다...
	public static void Crawl2() throws IOException {
		int result = 0;
		try {
			String urlEX = "https://www.musinsa.com/search/musinsa/goods?q=%EB%B0%9C%EB%A7%88%EC%B9%B8&list_kind=small&sortCode=pop&sub_sort=&page=1&display_cnt=0&saleGoods=false&includeSoldOut=false&setupGoods=false&popular=false&category1DepthCode=&category2DepthCodes=&category3DepthCodes=&selectedFilters=&category1DepthName=&category2DepthName=&brandIds=&price=&colorCodes=&contentType=&styleTypes=&includeKeywords=&excludeKeywords=&originalYn=N&tags=&campaignId=&serviceType=&eventType=&type=&season=&measure=&openFilterLayout=N&selectedOrderMeasure=&shoeSizeOption=&groupSale=false&d_cat_cd=&attribute="; // 눈건강
			
			Document doc = Jsoup.connect(urlEX).get(); 
			Elements ele = doc.select("div.list-box box"); 
			Iterator<Element> itr_brand = ele.select("p.item_title > a").iterator(); 
			Iterator<Element> itr_name = ele.select("div.article_info > p.list_info > a").iterator(); 
			Iterator<Element> itr_price = ele.select("p.price").iterator(); 
			
			while(itr_name.hasNext()) {
				System.out.println("브랜드 : " + itr_brand.next().text()); 
				System.out.println("상품명 : " + itr_name.next().attr("title")); 
				System.out.println("가격 : " + itr_price.next().text());
				result++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("크롤링 데이터 수 : " + result);
		}
	}
}
