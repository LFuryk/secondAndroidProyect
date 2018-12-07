package com.example.lfuryk.marketplace.model.retrofitImplementation;

import com.example.lfuryk.marketplace.model.Item;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
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

    public void call(Callback<ListProduct> callback){
        mMercadoLibreAPICall.getProducts("guitarras").enqueue(callback);
    }

}
