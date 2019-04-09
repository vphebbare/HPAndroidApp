package com.example.hindpolymers;

public class ProductDataModel {

    private String productName;
    private String productDescription;
    private int prodcutImage;

    public ProductDataModel(String productName, String productDescription, int prodcutImage) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.prodcutImage = prodcutImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public int getProdcutImage() {
        return prodcutImage;
    }
}
