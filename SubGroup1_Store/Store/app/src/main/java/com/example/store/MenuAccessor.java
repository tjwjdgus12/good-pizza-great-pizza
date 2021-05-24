package com.example.store;

import java.util.ArrayList;
import com.example.store.Menu;

public class MenuAccessor {
    private ArrayList<Menu> menu_list;

    public ArrayList<Menu> getMenu(){
        return this.menu_list;
    }

    public MenuAccessor(){}
}
