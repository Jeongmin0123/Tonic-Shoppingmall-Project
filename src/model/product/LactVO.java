package model.product;

public class LactVO {
//  속성(칼럼)
	private String l_no;      // 상품코르(PK) 예) LACT001 ??
	private String l_name;    // 상품명
	private String l_price;   // 가격
	private String l_details; // 상세정보
	private int l_period;     // 유통기간 예) 220410 
	private int l_date;       // 제조일자 예) 210908
	private String l_origin;  // 원산지
	private String l_manuf;   // 제조사
	private int l_sales;      // 판매량
	private int l_stock;      // 재고량
	
//  getter, setter
	public String getL_no() {
		return l_no;
	}
	public void setL_no(String l_no) {
		this.l_no = l_no;
	}
	public String getL_name() {
		return l_name;
	}
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}
	public String getL_price() {
		return l_price;
	}
	public void setL_price(String l_price) {
		this.l_price = l_price;
	}
	public String getL_details() {
		return l_details;
	}
	public void setL_details(String l_details) {
		this.l_details = l_details;
	}
	public int getL_period() {
		return l_period;
	}
	public void setL_period(int l_period) {
		this.l_period = l_period;
	}
	public int getL_date() {
		return l_date;
	}
	public void setL_date(int l_date) {
		this.l_date = l_date;
	}
	public String getL_origin() {
		return l_origin;
	}
	public void setL_origin(String l_origin) {
		this.l_origin = l_origin;
	}
	public String getL_manuf() {
		return l_manuf;
	}
	public void setL_manuf(String l_manuf) {
		this.l_manuf = l_manuf;
	}
	public int getL_sales() {
		return l_sales;
	}
	public void setL_sales(int l_sales) {
		this.l_sales = l_sales;
	}
	public int getL_stock() {
		return l_stock;
	}
	public void setL_stock(int l_stock) {
		this.l_stock = l_stock;
	}
}