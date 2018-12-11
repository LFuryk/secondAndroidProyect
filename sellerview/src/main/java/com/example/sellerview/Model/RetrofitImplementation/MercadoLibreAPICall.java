package com.example.sellerview.Model.RetrofitImplementation;

import com.example.sellerview.Model.Seller;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MercadoLibreAPICall {

    @GET("users/{id}")
    Call<Seller> getSeller(@Path("id") String id);

}

