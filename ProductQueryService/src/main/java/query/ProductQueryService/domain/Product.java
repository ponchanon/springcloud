package query.ProductQueryService.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
    @Id
    private String productNumber;
    private String name;
    private Double price;

    public Product(String productNumber, String name, Double price) {
        this.productNumber = productNumber;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "PNumber : "+productNumber+", Name :"+name+", Price: "+price;
    }
}
