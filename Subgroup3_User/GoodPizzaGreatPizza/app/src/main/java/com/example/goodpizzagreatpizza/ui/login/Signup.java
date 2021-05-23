package com.example.goodpizzagreatpizza.ui.login;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.goodpizzagreatpizza.R;

public class Signup extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //back 버튼 클릭시 액티비티 종료
        Button back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                finish();
            }
        });
    }
}