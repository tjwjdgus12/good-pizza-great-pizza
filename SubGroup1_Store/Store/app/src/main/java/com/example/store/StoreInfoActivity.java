package com.example.store;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class StoreInfoActivity extends AppCompatActivity {
    private TextView storeName, openTime, closeTime, location, callnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store_info);

        //matching textview with xml
        this.storeName = (TextView) findViewById(R.id.textView_storeName);
        this.openTime = (TextView) findViewById(R.id.textView_opentime);
        this.closeTime = (TextView) findViewById(R.id.textView_closetime);
        this.location = (TextView) findViewById(R.id.textView_location);
        this.callnumber = (TextView) findViewById(R.id.textView_callnumber);

        //getiing store info and synchronizing with textview
        StoreInfo si = new StoreInfoAccessor().getStoreInfo();
        this.storeName.setText(si.getName());
        this.openTime.setText(si.getOpentime());
        this.closeTime.setText(si.getClosetime());
        this.location.setText(si.getLocation());
        this.callnumber.setText(si.getCallnumber());
    }
}