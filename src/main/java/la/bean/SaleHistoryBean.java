package la.bean;

import java.io.Serializable;

public class SaleHistoryBean implements Serializable {

    private int productId;
    private String productName;
    private int saleId;
    private int price;

    public SaleHistoryBean(int productId, String productName, int saleId, int price) {
        this.productId = productId;
        this.productName = productName;
        this.saleId = saleId;
        this.price = price;
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
	