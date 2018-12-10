package com.example.lfuryk.marketplace.view;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.lfuryk.marketplace.R;
import com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall.DetailedProduct;
import com.example.lfuryk.marketplace.model.retrofitImplementation.DetailCall.SecureURL;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.Product;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class DetailedProductAdapter extends RecyclerView.Adapter<DetailedProductAdapter.EspecificProductHolder> {

    List<SecureURL> mURLS;

    public DetailedProductAdapter(List<SecureURL> list){
        this.mURLS = list;
    }


    @NonNull
    @Override
    public EspecificProductHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.detailed_item, viewGroup, false);

        return new EspecificProductHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull EspecificProductHolder especificProductHolder, int i) {
        SecureURL link = mURLS.get(i);

        Uri uri = Uri.parse(link.getSecureUrl());
        especificProductHolder.mImageView.setImageURI(uri);
    }

    @Override
    public int getItemCount() {
        return this.mURLS.size();
    }

    static class EspecificProductHolder extends RecyclerView.ViewHolder{

        private SimpleDraweeView mImageView;

        public EspecificProductHolder(@NonNull LinearLayout linearLayout) {
            super(linearLayout);
            mImageView = linearLayout.findViewById(R.id.detailed_product_image_view);
        }
    }
}
