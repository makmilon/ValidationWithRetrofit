package com.milon.milonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    TextView loginText;
    Spinner regGenger;
    Button regis_Btn;
    String re_firstN, re_lasN, re_age, re_gen, re_emai, re_ph, re_pass;
    EditText et_firstN, et_lasN, et_age, et_gen, et_emai, et_ph, et_pass;

    String[] gender= {"Select Gender","Male", "Female"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        loginText=findViewById(R.id.login_text);
        regis_Btn=findViewById(R.id.regis_btn);

        et_firstN=findViewById(R.id.first_name);
        et_lasN=findViewById(R.id.last_name);
        et_age=findViewById(R.id.age);
        regGenger=findViewById(R.id.reg_Gender);
        et_emai=findViewById(R.id.email);
        et_ph=findViewById(R.id.phone);
        et_pass=findViewById(R.id.password);


        loginText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });


        //spinner
        ArrayAdapter <String> adapter= new ArrayAdapter<String>(RegisterActivity.this, R.layout.color_spinner_layout, gender);
        adapter.setDropDownViewResource(R.layout.color_spinner_dropdown);
        regGenger.setAdapter(adapter);

        regGenger.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //spinner

       regis_Btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               re_firstN=et_firstN.getText().toString();
               re_lasN=et_lasN.getText().toString();
               re_age=et_age.getText().toString();
               re_emai=et_emai.getText().toString();
               re_ph=et_ph.getText().toString();
               re_pass=et_pass.getText().toString();

               //validation Info
               validationInfo(re_firstN, re_lasN, re_age, re_emai, re_ph, re_pass);

               if (validationInfo(re_firstN, re_lasN, re_age, re_emai, re_ph, re_pass)==true){

                   SharedPreferences sp= getSharedPreferences("details",MODE_PRIVATE);
                   SharedPreferences.Editor myEdit = sp.edit();
                   myEdit.putString("user_name",re_firstN);
                   myEdit.putString("user_lastname",re_lasN);
                   myEdit.putString("user_password",re_pass);
                   myEdit.commit();
                   Toast.makeText(getApplicationContext(),"Your registration is successful",Toast.LENGTH_SHORT).show();
                   startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
               }
           }
       });

    }

    private boolean validationInfo(String re_firstN, String re_lasN, String re_age, String re_emai, String re_ph, String re_pass) {
            if (re_firstN.length()==0){
                et_firstN.requestFocus();
                et_firstN.setError("Field Cant be Empty");
                return false;

            }else if(!re_firstN.matches("[a-zA-Z]+")){
                et_firstN.requestFocus();
                et_firstN.setError("Enter Only Alphabet Only");
                return false;

            }else if(re_lasN.length()==0){
                et_lasN.requestFocus();
                et_lasN.setError("Field Cant be Empty");
                return false;

            }else if(!re_lasN.matches("[a-zA-Z]+")){
                et_lasN.requestFocus();
                et_lasN.setError("Enter Only Alphabet Only");
                return false;

            }else if(re_age.equals("")){
                et_age.requestFocus();
                et_age.setError("Age should not empty");
                return false;
            }

            else if (re_emai.length()==0){
                et_emai.requestFocus();
                et_emai.setError("Field Cant be Empty");
                return false;

            }else if (!re_emai.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")){
                et_emai.requestFocus();
                et_emai.setError("Enter Valid Email");
                return false;
                
            }else if (re_ph.length()==0){
                et_ph.requestFocus();
                et_ph.setError("Field Cant be Empty");
                return false;

            }
            else if (!re_ph.matches("[0-9]{10}")){
                et_ph.requestFocus();
                et_ph.setError("Enter 10 digit Mobile No");
                return false;

            }else if (re_pass.length()==0){
                et_pass.requestFocus();
                et_pass.setError("Field Cant be Empty");
                return false;

            }else if (re_pass.length()<=5){
                et_pass.requestFocus();
                et_pass.setError("Minimum 6 Character required");
                return false;

            }
            else {
                return true;
            }
    }
}