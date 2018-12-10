package com.example.lfuryk.marketplace.presenter;

import com.example.lfuryk.marketplace.model.ItemHandler;
import com.example.lfuryk.marketplace.model.retrofitImplementation.APICall;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.ListProduct;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.Product;
import com.example.lfuryk.marketplace.view.MarketPlaceActivity;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MarketPlacePresenter {

    private MarketPlaceView mMarketPlaceActivity;
    private ItemHandler mIterator;
    private APICall mAPICall;

    public MarketPlacePresenter(MarketPlaceView marketPlaceActivity){

        this.mMarketPlaceActivity = marketPlaceActivity;

       mAPICall = new APICall();
    }

    public interface MarketPlaceView{
        void showError(String error);
        void setItems(List<Product> list);
    }

    public void onResume(){

        mAPICall.products("guitarras",new Callback<ListProduct>() {
            @Override
            public void onResponse(Call<ListProduct> call, Response<ListProduct> response) {
                mMarketPlaceActivity.setItems(response.body().getProducts());
            }

            @Override
            public void onFailure(Call<ListProduct> call, Throwable t) {
                mMarketPlaceActivity.showError("Can't load items");
            }
        });
    }

}
