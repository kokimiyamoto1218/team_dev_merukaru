package la.bean;

import java.io.Serializable;

public class SaleHistoryBean implements Serializable {
	private int id;
	private String name;
	private int saleid;
	private int price;

	public SaleHistoryBean(int id, String name, int saleid, int price) {
		this.id = id;
		this.name = name;
		this.saleid = saleid;
		this.price = price;
	}

	public SaleHistoryBean() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSaleid() {
		return saleid;
	}

	public void setSaleid(int saleid) {
		this.saleid = saleid;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
	
	
	