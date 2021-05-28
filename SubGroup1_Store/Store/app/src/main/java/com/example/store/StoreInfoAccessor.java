package com.example.store;

import com.example.store.StoreInfo;

public class StoreInfoAccessor {
    private StoreInfo store_info;

    public StoreInfoAccessor(){
        store_info = new StoreInfo("좋은피자 위대한피자", "08:00", "22:00", "Chung-Ang Univ.", "02-747-8282");
    }
    public StoreInfo getStoreInfo(){
        return this.store_info;
    }
}
