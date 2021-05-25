package com.example.store;

import android.media.Image;

//Is it right to use Image class? or BufferedImage?
public class PMenu {
    //attributes
    private String name;
    private int price;
    private Image img;

    //getter
    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public Image getImage(){
        return this.img;
    }

    //Initializers
    public PMenu(){
        this.name = "Hawaiian Pizza";
        this.price = 20000;
        this.img = null;
    }
    public PMenu(String name, int price){
        this.name = name;
        this.price = price;
        this.img = null;
    }
    public PMenu(String name, int price, Image img){
        this.name = name;
        this.price = price;
        this.img = img;
    }
}
