package com.example.lfuryk.marketplace.model;

public class Item {

    private String mName;
    private String mDescription;
    private String mPrice;

    public Item(String name, String description, String price){

        this.mName = name;
        this.mDescription = description;
        this.mPrice = price;

    }

    public String getDescription() {
        return this.mDescription;
    }

    public String getName() {
        return this.mName;
    }

    public String getPrice() {
        return this.mPrice;
    }
}
