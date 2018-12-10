package com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailedProduct {

    @SerializedName("pictures")
    private List<SecureURL> mSecureURLS;

    @SerializedName("title")
    private String mTittle;

    @SerializedName("price")
    private String mPrice;

    @SerializedName("warranty")
    private String mWarranty;

    @SerializedName("available_quantity")
    private String mAvailableQuantity;

    @SerializedName("condition")
    private String mCondition;

    @SerializedName("permalink")
    private String mPermalink;

    public DetailedProduct(List<SecureURL> secureURLS, String tittle, String price, String warranty, String availableQuantity, String permalink){
        this.mSecureURLS = secureURLS;
        this.mTittle = tittle;
        this.mPrice = price;
        this.mWarranty = warranty;
        this.mAvailableQuantity = availableQuantity;
        this.mPermalink = permalink;
    }

    public String getPrice() {
        return mPrice;
    }

    public String getAvailableQuantity() {
        return mAvailableQuantity;
    }

    public String getTittle() {
        return mTittle;
    }

    public String getWarranty() {
        return mWarranty;
    }

    public List<SecureURL> getSecureURLS() {
        return mSecureURLS;
    }

    public String getCondition() {
        return this.mCondition;
    }

    public String getPermalink() {
        return this.mPermalink;
    }
}
