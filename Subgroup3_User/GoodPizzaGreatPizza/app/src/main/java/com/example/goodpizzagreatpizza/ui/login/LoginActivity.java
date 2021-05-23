package  com.example.goodpizzagreatpizza.ui.login;

import android.app.Activity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.goodpizzagreatpizza.R;
import com.example.goodpizzagreatpizza.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SignController signController = new SignController();

        Button loginbtn = (Button) findViewById(R.id.login);
        EditText idEdit = (EditText) findViewById(R.id.username);
        EditText pwEdit = (EditText) findViewById(R.id.password);

        loginbtn.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){
                String str = signController.sign_in(idEdit.getText().toString(), pwEdit.getText().toString());
                switch(str){
                    case "Success":
                        Toast.makeText(getApplicationContext(), idEdit.getText().toString() + "님, 환영합니다.", Toast.LENGTH_LONG).show();
                        finish();
                        break;
                    case "Signin Failed":
                        Toast.makeText(getApplicationContext(), "로그인에 실패하였습니다.", Toast.LENGTH_LONG).show();
                        break;
                    case "Wrong Input":
                        Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 잘못되었습니다.", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "알 수 없는 오류가 발생하였습니다. " + str, Toast.LENGTH_LONG).show();
                        break;
                }
            }

        });

        Button signupbtn = (Button) findViewById(R.id.signup);
        signupbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}