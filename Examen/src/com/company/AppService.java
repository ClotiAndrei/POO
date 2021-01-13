package com.company;

import java.util.List;

public interface AppService <T>{
    T create(T a) throws ValidationFailedException;
    List<T> search(String s);
    boolean delete(T a) throws OfferNotFoundException;
}
