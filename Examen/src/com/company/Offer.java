package com.company;

import java.util.ArrayList;
import java.util.List;

public class Offer {
    private String customer;
    private List<Product> Products=new ArrayList<>() {
    };
    public Offer() {
    }

    public List<Product> getProducts() {
        return Products;
    }

    public void setProducts(List<Product> products) {
        Products = products;
    }

    public Double getTotalPrice(){
       Double TotalPrice=0.0;
        for(int i=0;i<getProducts().size();i++){
            TotalPrice+= getProducts().get(i).getPrice();
       }
        return TotalPrice;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
