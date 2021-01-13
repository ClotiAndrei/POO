package com.company;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ProductRepository {
   private Map<String,Product> products=new HashMap<String,Product>();


    public ProductRepository() {
    }

    public Product create(Product p){
        this.products.put(p.getName(),p);
    return p;
    }

    public boolean  delete(Product p) throws ProductNotFoundException {
        if (products.containsKey(p.getName())) {
            products.remove(p.getName());
            return true;
        } else {
            throw new ProductNotFoundException("Nu e in Map");
        }
    }

    public Map<String, Product> getProducts() {
        return products;
    }

    public void setProducts(Map<String, Product> products) {
        this.products = products;
    }
}
