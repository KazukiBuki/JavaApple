
package com.example.vejasjavaproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;

import org.w3c.dom.Text;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView username =(TextView) findViewById(R.id.username);
        TextView password =(TextView) findViewById(R.id.password);
        TextView email =(TextView) findViewById(R.id.email);
        TextView confirmpass =(TextView) findViewById(R.id.confirmpass);

        MaterialButton signinbtn = (MaterialButton) findViewById(R.id.signinbtn);

        signinbtn.setOnClickListener(view -> {

            boolean cancel = false;


            if(!isValid(username.getText().toString())){
                username.setError("Incorrect username or is invalid.");
                cancel = true;
            }
            if(!isValid(password.getText().toString())){
                password.setError("Incorrect password or is invalid.");
                cancel = true;
            }
            if(!isValid(email.getText().toString())){
                email.setError("Incorrect email or is invalid.");
                cancel = true;
            }
            if(!isValid(confirmpass.getText().toString())){
                confirmpass.setError("Incorrect password or is invalid.");
                cancel = true;
            }
            if(cancel){
                view.requestFocus();
            }else{
                Toast.makeText(RegisterActivity.this, "Account creation successful!", Toast.LENGTH_SHORT).show();

                openLogin();
            }




            Toast.makeText(RegisterActivity.this, "You have been redirected to the sign-in page", Toast.LENGTH_LONG).show();

            openLogin();
        });

    }

    private boolean isValid(String credentials){
        final String CREDENTIALS_PATTERN = "^[a-zA-Z0-9]{3,15}+$";

        Pattern pattern = Pattern.compile(CREDENTIALS_PATTERN);

        Matcher matcher = pattern.matcher(credentials);

        return matcher.matches();
    }
    public void openLogin(){
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
