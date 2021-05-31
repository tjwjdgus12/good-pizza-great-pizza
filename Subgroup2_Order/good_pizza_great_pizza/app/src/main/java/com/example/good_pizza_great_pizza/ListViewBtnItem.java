package com.example.good_pizza_great_pizza;

public class ListViewBtnItem {
    private String name;
    private String cost;
    private String count;

    public ListViewBtnItem(String name, String cost, String count){
        this.name = name;
        this.cost = cost;
        this.count = count;
    }

    public void setText_name(String text) {
        name = text ;
    }

    public void setText_cost(String text) {
        cost = text ;
    }

    public void setText_count(String text) {
        count = text ;
    }

    public String getText_name() {
        return this.name ;
    }

    public String getText_cost() {
        return this.cost ;
    }

    public String getText_count() {
        return this.count ;
    }
}