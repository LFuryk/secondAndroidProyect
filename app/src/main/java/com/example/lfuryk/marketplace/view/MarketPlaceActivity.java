package com.example.lfuryk.marketplace.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.example.lfuryk.marketplace.R;
import com.example.lfuryk.marketplace.model.Item;
import com.example.lfuryk.marketplace.model.retrofitImplementation.Product;
import com.example.lfuryk.marketplace.presenter.MarketPlacePresenter;

import java.util.List;

public class MarketPlaceActivity extends AppCompatActivity implements MarketPlaceView{

    private MarketPlacePresenter mMarketPlacePresenter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        mRecyclerView = findViewById(R.id.list);

        mMarketPlacePresenter = new MarketPlacePresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMarketPlacePresenter.onResume();
    }

    @Override
    public void setItems(List<Product> list) {
        mRecyclerView.setAdapter(new MarketPlaceAdapter(list));
    }
}
