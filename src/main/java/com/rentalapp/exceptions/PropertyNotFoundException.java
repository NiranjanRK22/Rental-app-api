package com.rentalapp.exceptions;

public class PropertyNotFoundException extends RuntimeException{
    public PropertyNotFoundException() {
    }

    /**
     *
     * @param message
     */
    public PropertyNotFoundException(String message) {
        super(message);
    }
}
