package com.example.sellerview.Presenter;

import com.example.sellerview.Model.RetrofitImplementation.APICall;
import com.example.sellerview.Model.Seller;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SellerPresenter {

    private SellerView mView;
    private APICall mAPICall;

    public SellerPresenter(SellerView view){
        this.mView = view;
        this.mAPICall = new APICall();
    }

    public void loadSeller(String id){
        mAPICall.getSeller(id, new Callback<Seller>() {
            @Override
            public void onResponse(Call<Seller> call, Response<Seller> response) {
                mView.loadSeller(response.body());
            }

            @Override
            public void onFailure(Call<Seller> call, Throwable t) {
                mView.showError("Can't load the seller profile");
            }
        });
    }


    public interface SellerView{

        void loadSeller(Seller seller);
        void showError(String err);

    }
}
