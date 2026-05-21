package la.bean;

import java.io.Serializable;

public class purchasehistoryBean implements Serializable {
	private int product_id;
	private String product_name;
	private int price;
	private int buyer_id;
	private String booking;

	public purchasehistoryBean(int product_id, String product_name,int price,int buyer_id, String booking) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.price = price;
		this.buyer_id = buyer_id;
		this.booking = booking;
		
	}

	public purchasehistoryBean() {

	}

	public int getProduct_id() {
		return product_id;
	}

	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getBuyer_id() {
		return buyer_id;
	}

	public void setBuyer_id(int buyer_id) {
		this.buyer_id = buyer_id;
	}

	public String getBooking() {
		return booking;
	}

	public void setBooking(String booking) {
		this.booking = booking;
	}

	
}