package la.bean;

import java.io.Serializable;

public class SaleHistoryBean implements Serializable {

    private int productId;
    private String productName;
    private int saleId;
    private int price;
    private int delete_flag;

    public SaleHistoryBean(int productId, String productName, int saleId, int price,int delete_flag) {
        this.productId = productId;
        this.productName = productName;
        this.saleId = saleId;
        this.price = price;
        this.delete_flag = delete_flag;
    }

    public int getDelete_flag() {
		return delete_flag;
	}

	public void setDelete_flag(int delete_flag) {
		this.delete_flag = delete_flag;
	}

	public SaleHistoryBean() {
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getSaleId() {
        return saleId;
    }

    public void setSaleId(int saleId) {
        this.saleId = saleId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
	