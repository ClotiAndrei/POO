package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class OfferServiceImpl implements OfferService{
    List<Offer> offers=new ArrayList<>();

    public OfferServiceImpl() {
    }

    @Override
    public List<Offer> findAllByProductName(String s) {
        List<Offer> ListaOferte=new ArrayList<>();
        for(int i=0;i<offers.size();i++){
            for(int j=0;j<offers.get(i).getProducts().size();j++)
                if(offers.get(i).getProducts().get(i).getName()==s){
                    ListaOferte.add(offers.get(i));
                }

        }
        return ListaOferte;
    }

    @Override
    public Offer create(Offer a) throws ValidationFailedException {
        if(a.getCustomer()!=null && a.getProducts().size()!=0)
            offers.add(a);
        else throw new ValidationFailedException();
        return null;
    }

    @Override
    public List<Offer> search(String s) {
        s.toLowerCase(Locale.ROOT);
        List<Offer> ListaOferte=new ArrayList<>();
        for(int i=0;i<offers.size();i++) {
            String dummy = offers.get(i).getCustomer();
            dummy.toLowerCase(Locale.ROOT);
            dummy.substring(0, s.length());
            if (dummy == offers.get(i).getCustomer())
                ListaOferte.add(offers.get(i));
        }
        return ListaOferte;
    }

    @Override
    public boolean delete(Offer a) throws OfferNotFoundException {
        if(offers.contains(a)){
            offers.remove(a);
            return true;
        }
        else throw  new OfferNotFoundException("Nu e in Lista");
    }

}
