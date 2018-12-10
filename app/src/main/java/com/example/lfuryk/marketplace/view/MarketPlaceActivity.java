package com.example.lfuryk.marketplace.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.lfuryk.marketplace.R;
import com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall.DetailedProduct;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.Product;
import com.example.lfuryk.marketplace.presenter.MarketPlacePresenter;

import java.util.List;

public class MarketPlaceActivity extends AppCompatActivity implements MarketPlacePresenter.MarketPlaceView{

    private MarketPlacePresenter mMarketPlacePresenter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        mRecyclerView = findViewById(R.id.list);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));

        mMarketPlacePresenter = new MarketPlacePresenter(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mMarketPlacePresenter.onResume();
    }

    @Override
    public void setItems(List<Product> list) {
        mRecyclerView.setAdapter(new MarketPlaceAdapter(list,mOnClickListener));
    }

    public void showError(String error){
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


    public void showProduct(String id) {
        Intent intent = new Intent(this, DetailedProductActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    private MarketPlaceAdapter.Listener mOnClickListener = new MarketPlaceAdapter.Listener() {
        @Override
        public void onClick(String id) {
            showProduct(id);
        }
    };
}
