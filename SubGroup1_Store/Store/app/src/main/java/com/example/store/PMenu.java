package com.example.store;

import android.media.Image;

//Is it right to use Image class?
public class PMenu {
    private String name;
    private int price;
    private Image img;

    public String getName(){
        return this.name;
    }
    public int getPrice(){
        return this.price;
    }
    public Image getImage(){
        return this.img;
    }

    public PMenu(){}
    public PMenu(String _name, int _price, Image _img){
        this.name = _name;
        this.price = _price;
        this.img = _img;
    }
    public PMenu(String _name, int _price){
        this.name = _name;
        this.price = _price;
    }
}
