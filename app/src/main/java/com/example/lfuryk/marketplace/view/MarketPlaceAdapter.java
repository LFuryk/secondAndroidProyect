package com.example.lfuryk.marketplace.view;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lfuryk.marketplace.R;
import com.example.lfuryk.marketplace.model.retrofitImplementation.MenuCall.Product;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class MarketPlaceAdapter extends RecyclerView.Adapter<MarketPlaceAdapter.ItemViewHolder> {

    private List<Product> mItems;


    public MarketPlaceAdapter(List<Product> items){
        this.mItems = items;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_item, viewGroup, false);
        linearLayout.setOnClickListener(mOnClickListener);
        return new ItemViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        Product product = mItems.get(i);
        itemViewHolder.mTittleTextView.setText(product.getName());
        itemViewHolder.mDescriptionTextView.setText(product.getDescription());
        itemViewHolder.mPriceTextView.setText("Precio: $"+product.getPrice());


        Uri uri = Uri.parse(product.getImageURI());
        itemViewHolder.mImageView.setImageURI(uri);

        /*DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        itemViewHolder.mImageView.setController(controller);*/

    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            /*
            * Intent to next view
            *
            */
        }
    };

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mTittleTextView;
        private TextView mPriceTextView;
        private TextView mDescriptionTextView;
        private SimpleDraweeView mImageView;

        public ItemViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            mTittleTextView = linearLayout.findViewById(R.id.item_tittle);
            mPriceTextView = linearLayout.findViewById(R.id.item_price);
            mDescriptionTextView = linearLayout.findViewById(R.id.item_description);
            mImageView = linearLayout.findViewById(R.id.my_image_view);
        }
    }
}
