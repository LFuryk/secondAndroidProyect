package com.example.sellerview.Model;

import com.google.gson.annotations.SerializedName;

public class Transactions {

    @SerializedName("canceled")
    private int mCanceled;

    @SerializedName("completed")
    private int mCompleted;

    @SerializedName("period")
    private String mPeriod;

    @SerializedName("ratings")
    private Ratings mRatings;

    @SerializedName("total")
    private int mTotal;

    public Transactions(int canceled, int completed, String period, Ratings ratings, int total){

        this.mCanceled = canceled;
        this.mCompleted = completed;
        this.mPeriod = period;
        this.mRatings = ratings;
        this.mTotal = total;

    }

    public int getCanceled() {
        return mCanceled;
    }

    public int getCompleted() {
        return mCompleted;
    }

    public int getTotal() {
        return mTotal;
    }

    public Ratings getRatings() {
        return mRatings;
    }

    public String getPeriod() {
        return mPeriod;
    }

}
