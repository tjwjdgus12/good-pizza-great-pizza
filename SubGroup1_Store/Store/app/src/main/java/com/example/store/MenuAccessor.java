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
        menu_list.add(new PMenu("하와이안 피자", 20000));
        menu_list.add(new PMenu("시카고 피자", 19000));
        menu_list.add(new PMenu("콤비네이션 피자", 18000));
        menu_list.add(new PMenu("어깨쭉 피자", 50000));
        menu_list.add(new PMenu("포테이토 피자", 16000));
        menu_list.add(new PMenu("베이컨 피자", 17000));
        menu_list.add(new PMenu("페퍼로니 피자", 15000));
        menu_list.add(new PMenu("블랙 알리오 피자", 23000));
        menu_list.add(new PMenu("웃음꽃 활짝 피자", 10000));
        menu_list.add(new PMenu("파김치 피자", 22000));
        menu_list.add(new PMenu("피자 피자", 20000));
        menu_list.add(new PMenu("피자헛", 18000));
        menu_list.add(new PMenu("병역기 피자", 0));
        menu_list.add(new PMenu("도미노피자", 18000));
        menu_list.add(new PMenu("헬로월드 피자", -1));
    }
}
