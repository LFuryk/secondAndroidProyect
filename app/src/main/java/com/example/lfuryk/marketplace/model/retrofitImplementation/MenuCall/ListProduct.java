package com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListProduct {

    @SerializedName("results")
    private List<Product> mProducts;

    public ListProduct(List<Product> products){
        this.mProducts = mProducts;
    }

    public List<Product> getProducts() {
        return this.mProducts;
    }
}
