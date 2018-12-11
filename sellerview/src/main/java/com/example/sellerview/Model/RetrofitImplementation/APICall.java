package com.example.sellerview.Model.RetrofitImplementation;

import com.example.sellerview.Model.Seller;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APICall {

    private MercadoLibreAPICall mMercadoLibreAPICall;

    public APICall(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mercadolibre.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mMercadoLibreAPICall = retrofit.create(MercadoLibreAPICall.class);
    }

    public void getSeller(String id, Callback<Seller> callback){
        mMercadoLibreAPICall.getSeller(id).enqueue(callback);
    }
}
