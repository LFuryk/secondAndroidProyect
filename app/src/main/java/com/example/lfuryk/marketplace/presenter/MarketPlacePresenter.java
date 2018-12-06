package com.example.lfuryk.marketplace.presenter;

import com.example.lfuryk.marketplace.model.Item;
import com.example.lfuryk.marketplace.model.ItemHandler;
import com.example.lfuryk.marketplace.view.MarketPlaceActivity;

import java.util.List;

public class MarketPlacePresenter {

    private MarketPlaceActivity mMarketPlaceActivity;
    private ItemHandler mIterator;

    public MarketPlacePresenter(MarketPlaceActivity marketPlaceActivity){

        this.mMarketPlaceActivity = marketPlaceActivity;

        mIterator = new ItemHandler();
        mIterator.createList();

    }

    public void onResume(){
        mMarketPlaceActivity.setItems(mIterator.getItems());
    }

}
