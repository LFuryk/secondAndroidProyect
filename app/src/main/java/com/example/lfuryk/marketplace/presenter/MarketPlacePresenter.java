package com.example.lfuryk.marketplace.presenter;

import android.util.Log;

import com.example.lfuryk.marketplace.model.Item;
import com.example.lfuryk.marketplace.model.ItemHandler;
import com.example.lfuryk.marketplace.model.retrofitImplementation.APICall;
import com.example.lfuryk.marketplace.model.retrofitImplementation.ListProduct;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MercadoLibreAPICall;
import com.example.lfuryk.marketplace.view.MarketPlaceActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketPlacePresenter {

    private MarketPlaceActivity mMarketPlaceActivity;
    private ItemHandler mIterator;
    private APICall mAPICall;

    public MarketPlacePresenter(MarketPlaceActivity marketPlaceActivity){

        this.mMarketPlaceActivity = marketPlaceActivity;

        /*mIterator = new ItemHandler();
        mIterator.createList();*/
       mAPICall = new APICall();



    }

    public void onResume(){

        mAPICall.call(new Callback<ListProduct>() {
            @Override
            public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
                mMarketPlaceActivity.setItems(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<ListProduct> call, Throwable t) {

            }
        });


        //mMarketPlaceActivity.setItems(mIterator.getItems());
    }

}
