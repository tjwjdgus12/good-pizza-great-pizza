package com.example.store;

import android.view.Menu;

import java.util.ArrayList;
import com.example.store.PMenu;

public class MenuAccessor {
    private ArrayList<PMenu> menu_list;

    public ArrayList<PMenu> getMenu(){
        return this.menu_list;
    }

    public MenuAccessor(){}
}
