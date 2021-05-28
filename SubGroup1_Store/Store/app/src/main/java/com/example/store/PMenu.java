package com.example.store;

import android.graphics.drawable.Drawable;


public class PMenu {
    //attributes
    private String name;
    private int price;
    /*private Image img;*/
    int img;

    //getter
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public int getImage(){
        return this.img;
    }

    //Initializers
    public PMenu(){
        this.name = "Hawaiian Pizza";
        this.price = 20000;
        this.img = 0;
    }
    public PMenu(String name, int price){
        this.name = name;
        this.price = price;
        this.img = 0;
    }
    public PMenu(String name, int price, int img){
        this.name = name;
        this.price = price;
        this.img = img;
    }
}
