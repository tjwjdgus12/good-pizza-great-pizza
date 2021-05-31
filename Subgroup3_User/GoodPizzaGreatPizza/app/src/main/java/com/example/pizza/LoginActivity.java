package com.example.pizza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizza.R;

public class LoginActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SignController signController = new SignController();


        EditText idEdit = (EditText) findViewById(R.id.userid);
        EditText pwEdit = (EditText) findViewById(R.id.password);
        Button loginbtn = (Button) findViewById(R.id.login);


        loginbtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String str = signController.sign_in(idEdit.getText().toString(), pwEdit.getText().toString());
                switch(str){
                    case "Success":
                        Toast.makeText(getApplicationContext(), idEdit.getText().toString() + "님, 환영합니다.", Toast.LENGTH_LONG).show();
                        finish();
                        Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                        startActivity(intent);
                        break;
                    case "Wrong ID Value":
                        Toast.makeText(getApplicationContext(), "ID를 확인하세요.", Toast.LENGTH_LONG).show();
                        break;
                    case "Wrong PW Value":
                        Toast.makeText(getApplicationContext(), "PW를 확인하세요.", Toast.LENGTH_LONG).show();
                        break;
                    case "Signin Failed":
                        Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_LONG).show();
                        break;
                    case "Wrong Input":
                        Toast.makeText(getApplicationContext(), "ID 또는 PW 가 잘못되었습니다.", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "알 수 없는 오류가 발생하였습니다. " + str, Toast.LENGTH_LONG).show();
                        break;
                }
            }

        });

        Button signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });


    }
}