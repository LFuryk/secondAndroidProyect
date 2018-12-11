package com.example.sellerview.Model;

import com.google.gson.annotations.SerializedName;

public class Transactions {

    @SerializedName("canceled")
    private String mCanceled;

    @SerializedName("completed")
    private String mCompleted;

    @SerializedName("period")
    private String mPeriod;

    @SerializedName("ratings")
    private Ratings mRatings;

    @SerializedName("total")
    private String mTotal;

    public Transactions(String canceled, String completed, String period, Ratings ratings, String total){

        this.mCanceled = canceled;
        this.mCompleted = completed;
        this.mPeriod = period;
        this.mRatings = ratings;
        this.mTotal = total;

    }

    public String getCanceled() {
        return mCanceled;
    }

    public String getCompleted() {
        return mCompleted;
    }

    public String getTotal() {
        return mTotal;
    }

    public Ratings getRatings() {
        return mRatings;
    }

    public String getPeriod() {
        return mPeriod;
    }

}
