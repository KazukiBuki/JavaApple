package com.example.vejasjavaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    private CheckBox rememberMeCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);

        TextView noaccount =(TextView) findViewById(R.id.noaccount);

        MaterialButton loginbtn = (MaterialButton) findViewById(R.id.loginbtn);
        MaterialButton registerbtn = (MaterialButton) findViewById(R.id.loginbtn);

        loginbtn.setOnClickListener(view -> {

            boolean cancel = false;


            if(!isValid(username.getText().toString())){
                username.setError("Incorrect username or is invalid.");
                cancel = true;
            }
            if(!isValid(password.getText().toString())){
                password.setError("Incorrect password or is invalid.");
                cancel = true;
            }
            if(cancel){
                view.requestFocus();
            }else{
                Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();

                openActivity2();
            }

//                if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin")){
//                    //correct
//                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
//                    openActivity2();
//                }else{
//                    //incorrect
//                    Toast.makeText(MainActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
//
//                }
        });

        registerbtn.setOnClickListener(view -> {
            Toast.makeText(LoginActivity.this, "You have been redirected to the registry page", Toast.LENGTH_LONG).show();

            openRegister();
        });

    }


    private boolean isValid(String credentials){
        final String CREDENTIALS_PATTERN = "^[a-zA-Z0-9]{3,15}+$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);

        return matcher.matches();
    }
    public void openActivity2(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
    public void openRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}