package com.milon.milonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    String user_nameS, user_lastS, user_passwordS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SharedPreferences sp= getSharedPreferences("details",MODE_PRIVATE);
                user_nameS=sp.getString("user_name","");
                user_lastS=sp.getString("user_lastname","");
                user_passwordS=sp.getString("user_password","");

                if (user_passwordS!="" && user_lastS!=""){
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
                else {
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                    finish();
                }



            }
        },100);
    }
}