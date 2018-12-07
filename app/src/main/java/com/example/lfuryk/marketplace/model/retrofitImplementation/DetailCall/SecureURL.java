package com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall;

import com.google.gson.annotations.SerializedName;

public class SecureURL {

    @SerializedName("secure_url")
    private String mSecureUrl;

    public SecureURL(String secureUrl){
        this.mSecureUrl = secureUrl;
    }

    public String getSecureUrl(){
        return mSecureUrl;
    }

}
