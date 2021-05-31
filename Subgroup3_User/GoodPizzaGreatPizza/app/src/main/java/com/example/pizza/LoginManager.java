package com.example.pizza;

public class LoginManager {
    private static Profile loginStatus;

    public boolean is_login() {
        if(loginStatus == null) {
            return false;
        }else {
            return true;
        }
    }

    public Boolean login_request(Profile info){
        loginStatus = info;
        return true;
    }
}
