package com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall;

import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.ListProduct;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MercadoLibreAPICall {

    @GET("sites/MLA/search")
    Call<ListProduct> getProducts(@Query("q") String query);
}
