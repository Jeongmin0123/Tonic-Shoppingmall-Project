package model.product;
/*
CREATE SEQUENCE PROD_SEQ;
CREATE TABLE PROD (
	item_brand VARCHAR(50),
	item_name VARCHAR(50),
	item_price NUMBER(10),
	item_discount VARCHAR(10),
	item_img VARCHAR(500)
);
*/
public class CrawlVO {
	private String pimg_src;
	private String pbrand;
	private String pnamee;
	private String pprice;
	private String pdiscount;
	private String pdetail;
	private int psales;
	private int pstock;
	
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
	public String getPnamee() {
		return pnamee;
	}
	public void setPnamee(String pnamee) {
		this.pnamee = pnamee;
	}
	
	public String getPprice() {
		return pprice;
	}
	public void setPprice(String pprice) {
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
		return "CrwalVO [pimg_src=" + pimg_src + ", pbrand=" + pbrand + ", pnamee=" + pnamee + ", pprice=" + pprice
				+ ", pdiscount=" + pdiscount + ", pdetail=" + pdetail + ", psales=" + psales + ", pstock=" + pstock
				+ "]";
	}
}
