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
    public MenuAccessor(){}
    public MenuAccessor(int num) {
        //for test
        menu_list = new ArrayList<PMenu>();
        menu_list.add(new PMenu("하와이안 피자", 20000, R.drawable.hawaiian_pizza));
        menu_list.add(new PMenu("시카고 피자", 19000, R.drawable.chicago_pizza));
        menu_list.add(new PMenu("콤비네이션 피자", 18000, R.drawable.combination_pizza));
        // menu_list.add(new PMenu("어깨쭉 피자", 50000, R.drawable.hawaiian_pizza));
        menu_list.add(new PMenu("포테이토 피자", 16000, R.drawable.potato_pizza));
        menu_list.add(new PMenu("베이컨 피자", 17000, R.drawable.bacon_pizza));
        menu_list.add(new PMenu("페퍼로니 피자", 15000, R.drawable.pepperoni_pizza));
        menu_list.add(new PMenu("알리오 피자", 23000, R.drawable.aglio_pizza));
        // menu_list.add(new PMenu("웃음꽃 활짝 피자", 10000, R.drawable.hawaiian_pizza));
        // menu_list.add(new PMenu("파김치 피자", 22000, R.drawable.hawaiian_pizza));
        menu_list.add(new PMenu("병역기 피자", 0, R.drawable.rok_army));
        // menu_list.add(new PMenu("도미노피자", 18000, R.drawable.hawaiian_pizza));
    }
}
