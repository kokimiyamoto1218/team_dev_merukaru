package la.bean;

import java.io.Serializable;

public class ItemBean implements Serializable {
	private int code;
	private String name;
	private int price;
	private String condition;
	private String neworused; 
	private int delete_frag;

	public ItemBean(int code,String name, int price,String condition,String neworused,int delete_frag) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.condition = condition;
		this.neworused = neworused;
		this.delete_frag = delete_frag;
	}

	public ItemBean() {

	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}
	
	public String getNeworused() {
		return neworused;
	}

	public void setNeworused(String neworused) {
		this.neworused = neworused;
	}

	public int getDelete_frag() {
		return delete_frag;
	}

	public void setDelete_frag(int delete_frag) {
		this.delete_frag = delete_frag;
	}
	
}