package com.example.lfuryk.marketplace.presenter;

import com.example.lfuryk.marketplace.model.retrofitImplementation.APICall;
import com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall.DetailedProduct;
import com.example.lfuryk.marketplace.view.DetailedProductActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailedProductPresenter {

    private APICall mAPICall;
    private DetailedProductView mView;
    private DetailedProduct model;

    public DetailedProductPresenter(DetailedProductView view){
        this.mView = view;
        mAPICall = new APICall();
    }

    public void loadProduct(String id){
        mAPICall.detailedProduct(id, new Callback<DetailedProduct>() {
            @Override
            public void onResponse(Call<DetailedProduct> call, Response<DetailedProduct> response) {
                model = response.body();
                mView.load(model);
            }

            @Override
            public void onFailure(Call<DetailedProduct> call, Throwable t) {
                mView.showError("Can't load the specific item");
            }
        });

    }

    public void nextPage(){
        mView.nextPage(model.getPermalink());
    }

    public void idSeller(){mView.idSeller(model.getSellerID());}

    public interface DetailedProductView{

        void load(DetailedProduct detailedProduct);
        void showError(String error);
        void nextPage(String permalink);
        void idSeller(String id);
    }

}
