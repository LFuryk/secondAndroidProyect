package com.example.sellerview.Model;

import com.google.gson.annotations.SerializedName;

public class Address {

    @SerializedName("city")
    private String mCity;

    @SerializedName("state")
    private String mState;

    public Address(String city, String state){
        this.mCity = city;
        this.mState = state;
    }

    public String getCity() {
        return mCity;
    }

    public String getState() {
        return mState;
    }
}
