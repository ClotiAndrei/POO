package com.company;

public class ValidationFailedException extends Exception{
    public ValidationFailedException() {
    }

    public ValidationFailedException(String message) {
        super(message);
    }
}
