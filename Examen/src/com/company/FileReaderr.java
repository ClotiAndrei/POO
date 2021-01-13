package com.company;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderr {

    public static List<Product> readProducts(String filePath){
        List<Product> ListaProduse=new ArrayList<>(100);

        try{
            BufferedReader bf=new BufferedReader(new FileReader(filePath));
            String line=null;
            int n=0;
            while ((line=bf.readLine())!=null){
                    String temp[]=line.split(",");
                    if(temp.length>1)
                        System.out.println(temp[0] + " " + temp[1]);
                        ListaProduse.get(n).setName(temp[0]);
                        int numar=Integer.parseInt(temp[1]);
                        ListaProduse.get(n).setPrice((double)numar);
                        n++;
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return ListaProduse;
    }
}
