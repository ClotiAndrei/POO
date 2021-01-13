package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class ProductService implements AppService<Product>{
    private ProductRepository Repozitory;
    @Override
    public Product create(Product a) throws ValidationFailedException{
        if(a.getName()!=null&&a.getPrice()>0)
            Repozitory.create(a);
        else throw new ValidationFailedException("Failed");
        return a;
    }

    @Override
    public List<Product> search(String s) {
        s.toLowerCase(Locale.ROOT);
        List<Product> ListaProduse= new ArrayList<>();
        for(Map.Entry<String,Product> entry :Repozitory.getProducts().entrySet()){
            String dummy=entry.getKey();
            dummy.toLowerCase(Locale.ROOT);
            dummy.substring(0,s.length());
            if(dummy==s){
                ListaProduse.add(entry.getValue());
            }
        }
        return ListaProduse;
    }

    @Override
    public boolean delete(Product a) {
        try {
            Repozitory.delete(a);
        }
        catch (ProductNotFoundException e){
            System.out.println(e.getMessage());
        }
        return false;
    }
}
