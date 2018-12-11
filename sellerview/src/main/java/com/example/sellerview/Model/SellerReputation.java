package com.example.sellerview.Model;

import com.google.gson.annotations.SerializedName;

public class SellerReputation {

    @SerializedName("level_id")
    private String mLevelID;

    @SerializedName("power_seller_status")

    private String mPowerSellerStatus;

    @SerializedName("transactions")
    private Transactions mTransactions;

}
