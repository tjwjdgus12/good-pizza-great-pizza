package com.example.pizza;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.pizza.R;

public class SignupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditText nameEdit = (EditText) findViewById(R.id.username);
        EditText addressEdit = (EditText) findViewById(R.id.useraddress);
        EditText phoneEdit = (EditText) findViewById(R.id.userphone);
        EditText idEdit = (EditText) findViewById(R.id.userid);
        EditText pwEdit = (EditText) findViewById(R.id.password);

        SignController signController = new SignController();

        //back 버튼 클릭시 액티비티 종료
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v) {
                finish();
            }
        });

        Button signupbtn = (Button) findViewById(R.id.request);
        signupbtn.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                String msg = signController.sign_up(idEdit.getText().toString(),
                        pwEdit.getText().toString(), nameEdit.getText().toString(),
                        addressEdit.getText().toString(), phoneEdit.getText().toString());
                switch(msg){
                    case "Wrong ID Value":
                        Toast.makeText(getApplicationContext(), "ID는 5글자 이상입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case "Wrong PW Value":
                        Toast.makeText(getApplicationContext(), "PW는 5글자 이상입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case "Success":
                        Toast.makeText(getApplicationContext(), "성공적으로 회원가입 되었습니다.", Toast.LENGTH_LONG).show();
                        finish();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                        break;
                    case "Already Exist":
                        Toast.makeText(getApplicationContext(), "이미 존재하는 ID 입니다.", Toast.LENGTH_LONG).show();
                        break;
                    case "Signup Failed":
                        Toast.makeText(getApplicationContext(), "회원가입에 실패하였습니다.", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "알 수 없는 오류가 발생하였습니다. : " + msg, Toast.LENGTH_LONG).show();
                        break;

                }

            }

        });
    }
}
