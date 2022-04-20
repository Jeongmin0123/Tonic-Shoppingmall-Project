package model.product;
/*
CREATE SEQUENCE PROD_SEQ;
CREATE TABLE product(
	pno VARCHAR(20) PRIMARY KEY, -- 상품번호 예) 001
	pcode VARCHAR(20),           -- 상품분류 예) 종합비타민, 유산균, 루테인
	pimg_src VARCHAR(2000),      -- 이미지 절대경로
	pbrand VARCHAR(1000),        -- 브랜드
	pname VARCHAR(1000),         -- 상품이름
	pprice NUMBER(10),           -- (할인된)가격
	pdiscount VARCHAR(10),       -- 할인율
	pdetail VARCHAR(2000),       -- 세부사항
	porigin VARCHAR(20),         -- 원산지
	pperiod VARCHAR(20),         -- 유통기한
	psales NUMBER(10) DEFAULT 0, -- 판매량
	pstock NUMBER(10) DEFAULT 0  -- 재고량
);
*/
public class ProductVO {
	   private String pno;
	   private String pcode;
	   private String pimg_src;
	   private String pbrand;
	   private String pname;
	   private int pprice;
	   private String pdiscount;
	   private String pdetail;
	   private String porigin;
	   private String pperiod;
	   private int psales;
	   private int pstock;
	   
	   public String getPno() {
	      return pno;
	   }
	   public void setPno(String pno) {
	      this.pno = pno;
	   }
	   public String getPcode() {
	      return pcode;
	   }
	   public void setPcode(String pcode) {
	      this.pcode = pcode;
	   }
	   public String getPimg_src() {
	      return pimg_src;
	   }
	   public void setPimg_src(String pimg_src) {
	      this.pimg_src = pimg_src;
	   }
	   public String getPbrand() {
	      return pbrand;
	   }
	   public void setPbrand(String pbrand) {
	      this.pbrand = pbrand;
	   }
	   public String getPname() {
	      return pname;
	   }
	   public void setPname(String pname) {
	      this.pname = pname;
	   }
	   
	   
	   
	   public int getPprice() {
		return pprice;
		}
		public void setPprice(int pprice) {
			this.pprice = pprice;
		}
		public String getPdiscount() {
		      return pdiscount;
		   }
	   public void setPdiscount(String pdiscount) {
	      this.pdiscount = pdiscount;
	   }
	   public String getPdetail() {
	      return pdetail;
	   }
	   public void setPdetail(String pdetail) {
	      this.pdetail = pdetail;
	   }
	   public String getPorigin() {
	      return porigin;
	   }
	   public void setPorigin(String porigin) {
	      this.porigin = porigin;
	   }
	   public String getPperiod() {
	      return pperiod;
	   }
	   public void setPperiod(String pperiod) {
	      this.pperiod = pperiod;
	   }
	   public int getPsales() {
	      return psales;
	   }
	   public void setPsales(int psales) {
	      this.psales = psales;
	   }
	   public int getPstock() {
	      return pstock;
	   }
	   public void setPstock(int pstock) {
	      this.pstock = pstock;
	   }
	   
	   @Override
	   public String toString() {
	      return "ProductVO [pno=" + pno + ", pimg_src=" + pimg_src + ", pbrand=" + pbrand + ", pname=" + pname
	            + ", pprice=" + pprice + ", pdiscount=" + pdiscount + ", pdetail=" + pdetail + ", porigin=" + porigin
	            + ", pperiod=" + pperiod + ", psales=" + psales + ", pstock=" + pstock + "]";
	   }
	}