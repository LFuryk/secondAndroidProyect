package com.example.lfuryk.marketplace;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;


public class MarketPlaceApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
