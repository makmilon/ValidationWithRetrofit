package com.milon.milonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    TextView registerText;
    EditText username, password;
    Button loginBtn;

    String userNaLast,  userPa;
    String user_nameS, user_lastS, user_passwordS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        registerText=findViewById(R.id.registerText);
        username=findViewById(R.id.user_nameLogin);
        password=findViewById(R.id.pass_wordLogin);
        loginBtn=findViewById(R.id.login_button);

        loginBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SharedPreferences sp= getSharedPreferences("details",MODE_PRIVATE);
                user_nameS=sp.getString("user_name","");
                user_lastS=sp.getString("user_lastname","");
                user_passwordS=sp.getString("user_password","");

                String userNameAndLasname= user_nameS + user_lastS;

                userNaLast=username.getText().toString();
                userPa=password.getText().toString();

                if (user_nameS.equals(userNaLast) && user_passwordS.equals(userPa) ){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                }else {
                    Toast.makeText(getApplicationContext(),"Wrong Credential",Toast.LENGTH_SHORT).show();
                }

            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });
    }

    @Override
    public void onBackPressed() {

    }
}