package com.example.ongajong.fastout2;

/**
 * Created by ongajong on 12/4/2017.
 */

public class Product {
    private String productId;
    private String name;
    //private String description;
    private double price;

    public String getProductId(){return productId;}
    public String getName(){return name;}
   // public String getDescription(){return description+"\n";}
    public double getPrice(){return price;}

    public Product(String productId, String name, double price){
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}
