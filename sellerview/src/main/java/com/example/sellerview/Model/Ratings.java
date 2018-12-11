package com.example.sellerview.Model;

import com.google.gson.annotations.SerializedName;

public class Ratings {

    @SerializedName("negative")
    private String mNegative;

    @SerializedName("neutral")
    private String mNeutral;

    @SerializedName("positive")
    private String mPositive;

    public Ratings(String negative, String neutral, String positive){

        this.mNegative = negative;
        this.mNeutral = neutral;
        this.mPositive = positive;

    }

    public String getNegative() {
        return mNegative;
    }

    public String getNeutral() {
        return mNeutral;
    }

    public String getPositive() {
        return mPositive;
    }
}
