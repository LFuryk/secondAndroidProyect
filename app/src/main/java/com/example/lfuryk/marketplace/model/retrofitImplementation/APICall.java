package com.example.lfuryk.marketplace.model.retrofitImplementation;

import com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall.DetailedProduct;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.ListProduct;

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

    public void products(String query, Callback<ListProduct> callback){
        mMercadoLibreAPICall.getProducts(query).enqueue(callback);
    }

    public void detailedProduct(String id, Callback<DetailedProduct> callback){
        mMercadoLibreAPICall.detailedProduct(id).enqueue(callback);
    }



}
