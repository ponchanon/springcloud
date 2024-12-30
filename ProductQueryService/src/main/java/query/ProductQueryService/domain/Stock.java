package query.ProductQueryService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Stock {

    @Id
    private String productNumber;
    private int stockNum;

    public Stock(String productNumber, int stockNum) {
        this.productNumber = productNumber;
        this.stockNum = stockNum;
    }

    public Stock() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public int getStockNum() {
        return stockNum;
    }

    public void setStockNum(int stockNum) {
        this.stockNum = stockNum;
    }

    @Override
    public String toString() {
        return "Product : "+productNumber+", Stock: "+stockNum;
    }
}

