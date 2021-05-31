package com.example.pizza;

public class Validator {

    public boolean isIdValid(String userid){
        return userid.trim().length() < 5;
    }

    public boolean isPasswordValid(String password){
        return password.trim().length() < 5;
    }
}
