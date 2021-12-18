package model.product;

public class EyesVO {
//  속성(칼럼)
	private String e_no;      // 상품코르(PK) 예) EYES001 ??
	private String e_name;    // 상품명
	private String e_price;   // 가격
	private String e_details; // 상세정보
	private int e_period;     // 유통기간 예) 220410 
	private int e_date;       // 제조일자 예) 210908
	private String e_origin;  // 원산지
	private String e_manuf;   // 제조사
	private int e_sales;      // 판매량
	private int e_stock;      // 재고량
	
//  getter, setter
	public String getE_no() {
		return e_no;
	}
	public void setE_no(String e_no) {
		this.e_no = e_no;
	}
	public String getE_name() {
		return e_name;
	}
	public void setE_name(String e_name) {
		this.e_name = e_name;
	}
	public String getE_price() {
		return e_price;
	}
	public void setE_price(String e_price) {
		this.e_price = e_price;
	}
	public String getE_details() {
		return e_details;
	}
	public void setE_details(String e_details) {
		this.e_details = e_details;
	}
	public int getE_period() {
		return e_period;
	}
	public void setE_period(int e_period) {
		this.e_period = e_period;
	}
	public int getE_date() {
		return e_date;
	}
	public void setE_date(int e_date) {
		this.e_date = e_date;
	}
	public String getE_origin() {
		return e_origin;
	}
	public void setE_origin(String e_origin) {
		this.e_origin = e_origin;
	}
	public String getE_manuf() {
		return e_manuf;
	}
	public void setE_manuf(String e_manuf) {
		this.e_manuf = e_manuf;
	}
	public int getE_sales() {
		return e_sales;
	}
	public void setE_sales(int e_sales) {
		this.e_sales = e_sales;
	}
	public int getE_stock() {
		return e_stock;
	}
	public void setE_stock(int e_stock) {
		this.e_stock = e_stock;
	}
}
