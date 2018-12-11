package com.example.sellerview.Model;

import com.google.gson.annotations.SerializedName;

public class Seller {

    @SerializedName("id")
    private long mID;

    @SerializedName("nickname")
    private String mNickname;

    @SerializedName("address")
    private Address mAddress;

    @SerializedName("seller_reputation")
    private SellerReputation mSellerReputation;

    public Seller(long id, String nickname, Address address, SellerReputation sellerReputation){

        this.mID = id;
        this.mNickname = nickname;
        this.mAddress = address;
        this.mSellerReputation = sellerReputation;

    }

    public Address getAddress() {
        return mAddress;
    }

    public long getID() {
        return mID;
    }

    public SellerReputation getSellerReputation() {
        return mSellerReputation;
    }

    public String getNickname() {
        return mNickname;
    }
}
