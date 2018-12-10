package com.example.lfuryk.marketplace.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.KeyEvent;
import android.view.View;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.example.lfuryk.marketplace.R;
import com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall.DetailedProduct;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.Product;
import com.example.lfuryk.marketplace.presenter.MarketPlacePresenter;

import java.util.List;

public class MarketPlaceActivity extends AppCompatActivity implements MarketPlacePresenter.MarketPlaceView{

    private MarketPlacePresenter mMarketPlacePresenter;
    private RecyclerView mRecyclerView;
    private SearchView mSearchView;

    private final String DEFAULT_SEARCH = "Guitarra";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_place);

        mRecyclerView = findViewById(R.id.list);
        mSearchView = findViewById(R.id.markeplace_search);
        mSearchView.setIconified(false);
        mSearchView.setOnQueryTextListener(mSearchKey);

        mMarketPlacePresenter = new MarketPlacePresenter(this);

        Intent intent = getIntent();
        String action = intent.getAction();
        Uri data = intent.getData();
        mSearchView.setQuery(data.getPath(),true);

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getSharedPreferences("LAST_SEARCH", MODE_PRIVATE);
        String restoredText = prefs.getString("LAST_SEARCH", "");

        if(restoredText.isEmpty()) {
            mMarketPlacePresenter.onResume(DEFAULT_SEARCH);
        }else{
            mMarketPlacePresenter.onResume(restoredText);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences.Editor editor = getSharedPreferences("LAST_SEARCH", MODE_PRIVATE).edit();
        editor.putString("LAST_SEARCH", mSearchView.getQuery().toString());
        editor.apply();
    }

    @Override
    public void setItems(List<Product> list) {
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
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

    private SearchView.OnClickListener mSearchIconified = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mSearchView.setIconified(false);
        }
    };

    private SearchView.OnQueryTextListener mSearchKey = new SearchView.OnQueryTextListener() {

        @Override
        public boolean onQueryTextSubmit(String query) {
            if ((!query.isEmpty())) {
                mMarketPlacePresenter.onResume(query);
            } else {
                mMarketPlacePresenter.onResume(DEFAULT_SEARCH);
            }
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {

            if ((!newText.isEmpty())) {
                mMarketPlacePresenter.onResume(newText);
            } else {
                mMarketPlacePresenter.onResume(DEFAULT_SEARCH);
            }
            return false;
        }

    };

}
