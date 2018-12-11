package com.example.sellerview.Model;

import com.google.gson.annotations.SerializedName;

public class SellerReputation {

    @SerializedName("level_id")
    private String mLevelID;

    @SerializedName("power_seller_status")

    private String mPowerSellerStatus;

    @SerializedName("transactions")
    private Transactions mTransactions;

    public SellerReputation(String levelID, String powerSellerStatus, Transactions transactions){
        this.mLevelID = levelID;
        this.mPowerSellerStatus = powerSellerStatus;
        this.mTransactions = transactions;
    }

    public String getLevelID() {
        return mLevelID;
    }

    public String getPowerSellerStatus() {
        return mPowerSellerStatus;
    }

    public Transactions getTransactions() {
        return mTransactions;
    }
}
