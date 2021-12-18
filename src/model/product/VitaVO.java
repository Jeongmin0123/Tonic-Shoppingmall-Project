package model.product;

public class VitaVO {
//  속성(칼럼)
	private String v_no;      // 상품코르(PK) 예) VITA001 ??
	private String v_name;    // 상품명
	private String v_price;   // 가격
	private String v_details; // 상세정보
	private int v_period;     // 유통기간 예) 220410 
	private int v_date;       // 제조일자 예) 210908
	private String v_origin;  // 원산지
	private String v_manuf;   // 제조사
	private int v_sales;      // 판매량
	private int v_stock;      // 재고량
	
//  getter, setter
	public String getV_no() {
		return v_no;
	}
	public void setV_no(String v_no) {
		this.v_no = v_no;
	}
	public String getV_name() {
		return v_name;
	}
	public void setV_name(String v_name) {
		this.v_name = v_name;
	}
	public String getV_price() {
		return v_price;
	}
	public void setV_price(String v_price) {
		this.v_price = v_price;
	}
	public String getV_details() {
		return v_details;
	}
	public void setV_details(String v_details) {
		this.v_details = v_details;
	}
	public int getV_period() {
		return v_period;
	}
	public void setV_period(int v_period) {
		this.v_period = v_period;
	}
	public int getV_date() {
		return v_date;
	}
	public void setV_date(int v_date) {
		this.v_date = v_date;
	}
	public String getV_origin() {
		return v_origin;
	}
	public void setV_origin(String v_origin) {
		this.v_origin = v_origin;
	}
	public String getV_manuf() {
		return v_manuf;
	}
	public void setV_manuf(String v_manuf) {
		this.v_manuf = v_manuf;
	}
	public int getV_sales() {
		return v_sales;
	}
	public void setV_sales(int v_sales) {
		this.v_sales = v_sales;
	}
	public int getV_stock() {
		return v_stock;
	}
	public void setV_stock(int v_stock) {
		this.v_stock = v_stock;
	}
}
