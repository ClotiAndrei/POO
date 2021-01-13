package com.company;

public class OfferNotFoundException extends Exception{
    public OfferNotFoundException() {
    }

    public OfferNotFoundException(String message) {
        super(message);
    }
}
