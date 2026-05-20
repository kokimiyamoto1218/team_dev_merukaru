package la.bean;

import java.io.Serializable;

public class ItemBean implements Serializable {
	private int code;
	private int catecode;
	private String name;
	private int price;

	public ItemBean(int code, int catecode,String name, int price) {
		this.code = code;
		this.catecode = catecode;
		this.name = name;
		this.price = price;
	}

	public ItemBean() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
	
	public int getCatecode() {
		return catecode;
	}

	public void setCatecode(int catecode) {
		this.catecode = catecode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}