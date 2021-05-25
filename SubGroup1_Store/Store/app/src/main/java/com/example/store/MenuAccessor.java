package com.example.store;

import java.util.ArrayList;

public class MenuAccessor {
    //attributes
    private ArrayList<PMenu> menu_list;

    //getter
    public ArrayList<PMenu> getMenu(){
        return this.menu_list;
    }

    //Initializers
    public MenuAccessor(){
        this(1);
    }
    public MenuAccessor(int _num) {
       menu_list = new ArrayList<PMenu>();
       for(int i = 0; i < _num; i++) {
           menu_list.add(new PMenu("Hawaiian Pizza", 20000));
       }
    }
}
