package com.rentalapp.exceptions;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException() {
    }

    /**
     *
     * @param message
     */
    public CategoryNotFoundException(String message) {
        super(message);
    }
}
