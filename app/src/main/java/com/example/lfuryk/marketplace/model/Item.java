package com.example.lfuryk.marketplace.model;

public class Item {

    private String mName;
    private String mDescription;
    private String mPrice;
    private String mImageURI;

    public Item(String name, String description, String price, String imageURI) {

        this.mName = name;
        this.mDescription = description;
        this.mPrice = price;
        this.mImageURI = imageURI;

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

    public String getImageURI() {
        return this.mImageURI;
    }
}
