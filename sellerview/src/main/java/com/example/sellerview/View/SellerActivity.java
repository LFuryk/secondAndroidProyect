package com.example.sellerview.View;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sellerview.Model.Ratings;
import com.example.sellerview.Model.Seller;
import com.example.sellerview.Presenter.SellerPresenter;
import com.example.sellerview.R;

public class SellerActivity extends AppCompatActivity implements SellerPresenter.SellerView {

    private SellerPresenter mPresenter;

    private TextView mSellerName;
    private TextView mTotalSales;
    private TextView mSellerCategory;
    private TextView mTotalOpinions;

    private ProgressBar mGoodOpinions;
    private ProgressBar mRegularOpinions;
    private ProgressBar mBadOpinions;

    private TextView mSellerLocation;

    String mIDSeller;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller);

        mPresenter = new SellerPresenter(this);

        mSellerName = findViewById(R.id.seller_name);
        mTotalSales = findViewById(R.id.seller_total_sales);
        mSellerCategory = findViewById(R.id.seller_category);
        mTotalOpinions = findViewById(R.id.seller_total_opinions);

        mGoodOpinions = findViewById(R.id.seller_good_opinions);
        mRegularOpinions = findViewById(R.id.seller_regular_opinions);
        mBadOpinions = findViewById(R.id.seller_bad_opinions);

        mSellerLocation = findViewById(R.id.seller_location);

        Intent intent = getIntent();
        mIDSeller = intent.getStringExtra("id");
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadSeller(mIDSeller);
    }

    @Override
    public void loadSeller(Seller seller) {

        mSellerName.setText(seller.getNickname());
        mTotalSales.setText(seller.getSellerReputation().getTransactions().getTotal() + " ventas en total!");
        mSellerCategory.setText("MercadoLíder " + seller.getSellerReputation().getPowerSellerStatus());

        Ratings ratings = seller.getSellerReputation().getTransactions().getRatings();

        int positive = toInt(ratings.getPositive());
        int neutral = toInt(ratings.getNeutral());
        int negative = toInt(ratings.getNegative());


        mTotalOpinions.setText(seller.getSellerReputation().getTransactions().getCompleted());
        mGoodOpinions.setProgress(positive);
        mRegularOpinions.setProgress(neutral);
        mBadOpinions.setProgress(negative);

        mSellerLocation.setText(seller.getAddress().getCity() + ", "+seller.getAddress().getState());

    }

    @Override
    public void showError(String err) {
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }

    private int toInt(String str){
      if(str.length()>1){
        return Integer.parseInt((str).substring(2));
      } else{
          return Integer.parseInt(str);
      }
    }
}
