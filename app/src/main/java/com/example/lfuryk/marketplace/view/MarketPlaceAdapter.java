package com.example.lfuryk.marketplace.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lfuryk.marketplace.R;
import com.example.lfuryk.marketplace.model.Item;

import java.util.List;

public class MarketPlaceAdapter extends RecyclerView.Adapter<MarketPlaceAdapter.ItemViewHolder> {

    private List<Item> mItems;


    public MarketPlaceAdapter(List<Item> items){
        this.mItems = items;
    }


    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_item, viewGroup, false);
        return new ItemViewHolder(linearLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        Item item = mItems.get(i);
        itemViewHolder.mTittleTextView.setText(item.getName());
        itemViewHolder.mDescriptionTextView.setText(item.getDescription());
        itemViewHolder.mPriceTextView.setText(item.getPrice());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView mTittleTextView;
        private TextView mPriceTextView;
        private TextView mDescriptionTextView;

        public ItemViewHolder(LinearLayout linearLayout) {
            super(linearLayout);
            mTittleTextView = linearLayout.findViewById(R.id.item_tittle);
            mPriceTextView = linearLayout.findViewById(R.id.item_price);
            mDescriptionTextView = linearLayout.findViewById(R.id.item_description);
        }
    }
}
