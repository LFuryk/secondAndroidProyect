package com.example.sellerview.Model;

import com.google.gson.annotations.SerializedName;

public class Ratings {

    @SerializedName("negative")
    private double mNegative;

    @SerializedName("neutral")
    private double mNeutral;

    @SerializedName("positive")
    private double mPositive;

    public Ratings(double negative, double neutral, double positive){

        this.mNegative = negative * 100;
        this.mNeutral = negative * 100;
        this.mPositive = positive * 100;

    }

    public double getNegative() {
        return mNegative;
    }

    public double getNeutral() {
        return mNeutral;
    }

    public double getPositive() {
        return mPositive;
    }
}
