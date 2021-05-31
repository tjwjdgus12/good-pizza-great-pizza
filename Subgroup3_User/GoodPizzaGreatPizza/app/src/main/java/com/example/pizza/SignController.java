package com.example.pizza;

public class SignController {


    static private UserDBAccess DB;
    static private LoginManager loginManager;
    Validator valid_signin = new Validator();
    Validator valid_signup = new Validator();

    public SignController() {
        if(DB == null)
            DB = new UserDBAccess();
        if(loginManager == null)
            loginManager = new LoginManager();
    }

    public int test() {
        return 1;
    }

    public String sign_in(String id, String pw) {


        if (valid_signin.isIdValid(id)){
            return "Wrong ID Value";
        }

        if (valid_signin.isPasswordValid(pw)){
            return "Wrong PW Value";
        }

        Token t = new Token(id, pw);
        Profile p = DB.auth(t);
        if(p == null) {
            return "Wrong Input";
        }

        if(loginManager.login_request(p)) {
            return "Success";
        } else {
            return "Signin Failed";
        }

    }

    public String sign_up(String id, String pw, String name, String address, String phonenum){


        Token t = new Token(id, pw);

        if (valid_signin.isIdValid(id)){
            return "Wrong ID Value";
        }

        if (valid_signin.isPasswordValid(pw)){
            return "Wrong PW Value";
        }

        if(DB.find(t)) {
            return "Already Exist";
        }
        if(DB.add(id, pw, name, address, phonenum)) {
            return "Success";
        } else {
            return "Signup Failed";
        }

    }
}
