package com.example.lfuryk.marketplace.model;

import java.util.ArrayList;
import java.util.List;

public class ItemHandler {

    private ArrayList<Item> mItems;

    public ItemHandler(){
        mItems = new ArrayList<Item>();
    }

    public void createList(){
        Item item1 = new Item("phone","iphone 8", "28.000");
        mItems.add(item1);

        Item item2 = new Item("mate","mate calabaza", "200");
        mItems.add(item2);

        Item item3 = new Item("proyecto","proyecto 2018", "8.000");
        mItems.add(item3);

        Item item4 = new Item("phone","iphone 8", "28.000");
        mItems.add(item4);

        Item item5 = new Item("mate","mate calabaza", "200");
        mItems.add(item5);

        Item item6 = new Item("proyecto","proyecto 2018", "8.000");
        mItems.add(item6);

        Item item7 = new Item("phone","iphone 8", "28.000");
        mItems.add(item7);

        Item item8 = new Item("mate","mate calabaza", "200");
        mItems.add(item8);

        Item item9 = new Item("proyecto","proyecto 2018", "8.000");
        mItems.add(item9);
    }

    public Item getItem(int n){
        if(n>0 && n<mItems.size()){
            return mItems.get(n);
        }else {
            return null;
        }
    }

    public List<Item> getItems(){
        return this.mItems;
    }
}
