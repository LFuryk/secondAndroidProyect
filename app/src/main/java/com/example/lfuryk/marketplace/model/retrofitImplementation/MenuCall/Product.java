package com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall;

import com.google.gson.annotations.SerializedName;

public class Product {

    @SerializedName("title")
    private String mName;

    @SerializedName("condition")
    private String mDescription;

    @SerializedName("price")
    private String mPrice;

    @SerializedName("thumbnail")
    private String mImageURI;

    public Product(String name, String description, String price, String imageURI) {

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
