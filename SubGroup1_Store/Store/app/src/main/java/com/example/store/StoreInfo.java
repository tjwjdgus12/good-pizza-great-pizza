package com.example.store;

public class StoreInfo {
    private String name;
    private String opentime;
    private String closetime;
    private String location;

    public String getName(){
        return this.name;
    }
    public String getOpentime(){
        return this.opentime;
    }
    public String getClosetime(){
        return this.closetime;
    }
    public String getLocation(){
        return this.location;
    }

    public StoreInfo(){}
    public StoreInfo(String _name, String _open, String _close, String _loc){
        this.name = _name;
        this.opentime = _open;
        this.closetime = _close;
        this.location = _loc;
    }
}
