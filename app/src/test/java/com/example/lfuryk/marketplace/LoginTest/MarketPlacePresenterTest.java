package com.example.lfuryk.marketplace.LoginTest;

import com.example.lfuryk.marketplace.model.retrofitImplementation.APICall;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.ListProduct;
import com.example.lfuryk.marketplace.presenter.MarketPlacePresenter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class MarketPlacePresenterTest {

    @Mock
    MarketPlacePresenter.MarketPlaceView mView;

    @Mock
    retrofit2.Callback<ListProduct> mCallback;

    @Mock Call<ListProduct> call;

    @Mock
    APICall mAPICall;

    @Test
    public void onResume(){
       MarketPlacePresenter marketPlacePresenter = new MarketPlacePresenter(mView);

       String query = "casas";
       marketPlacePresenter.onResume(query);

       verify(mAPICall,times(1)).products(query,marketPlacePresenter.getCallback());

    }

}
