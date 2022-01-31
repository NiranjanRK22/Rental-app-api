package com.rentalapp.model;

public enum Bedrooms {
    ONE("1 BHK"), TWO("2 BHK"), THREE("3 BHK"), FOUR("4 BHK"), FIVE("5 BHK");

    public final String count;

    private Bedrooms(String count)  {
        this.count = count;
    }
}
