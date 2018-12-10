package com.example.lfuryk.marketplace.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lfuryk.marketplace.R;
import com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall.DetailedProduct;
import com.example.lfuryk.marketplace.presenter.DetailedProductPresenter;
import com.facebook.drawee.view.SimpleDraweeView;


public class DetailedProductActivity extends AppCompatActivity implements DetailedProductPresenter.DetailedProductView{

    private DetailedProductPresenter mPresenter;

    private TextView mTitle;
    private TextView mPrice;
    private TextView mCondition;
    private TextView mQuantity;
    private Button mButton;
    private TextView mWarranty;

    private RecyclerView mRecyclerView;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_product);

        mPresenter = new DetailedProductPresenter(this);

        id = getIntent().getStringExtra("id");

        mTitle = findViewById(R.id.detailed_product_title);
        mPrice = findViewById(R.id.detailed_product_price);
        mCondition = findViewById(R.id.detailed_product_condition);
        mQuantity = findViewById(R.id.detailed_product_quantity);
        mWarranty = findViewById(R.id.detailed_product_warranty);

        mButton = findViewById(R.id.detailed_product_buy_button);
        mButton.setOnClickListener(mOnClickListener);

        mRecyclerView = findViewById(R.id.detailed_product_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));


    }


    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.loadProduct(id);
    }

    public void load(DetailedProduct detailedProduct){

        mTitle.setText(detailedProduct.getTittle());
        mPrice.setText("$" + detailedProduct.getPrice());
        mCondition.setText(detailedProduct.getCondition());
        mQuantity.setText("Only " + detailedProduct.getAvailableQuantity() + " left!");
        mWarranty.setText(detailedProduct.getWarranty());


        mRecyclerView.setAdapter(new DetailedProductAdapter(detailedProduct.getSecureURLS()));


    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void nextPage(String permalink) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(permalink));
        startActivity(intent);
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mPresenter.nextPage();
        }
    };
}
