package com.example.store;

import com.example.store.StoreInfo;

public class StoreInfoAccessor {
    private StoreInfo store_info;

    public StoreInfoAccessor(){
        store_info = new StoreInfo("good-pizza-great-pizza", "08:00", "22:00", "Chung-Ang Univ.");
    }
    public StoreInfo getStoreInfo(){
        return this.store_info;
    }
}
