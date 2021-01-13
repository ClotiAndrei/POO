package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        /*FileReaderr.readProducts("date.txt");*/
        Product produs = new Product();
        produs.setName("Detergent");
        produs.setPrice(10.0);
        ProductService Service = new ProductService();
        try {
            Product p2 = Service.create(produs);
        } catch (ValidationFailedException e) {
            e.printStackTrace();
        }


    }
}
