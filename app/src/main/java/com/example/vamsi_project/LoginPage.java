package com.example.vamsi_project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    EditText username,password;
    Button login;
    TextView signUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        username=findViewById(R.id.username);
        password=findViewById(R.id.password);

        login=findViewById(R.id.loginButton);
        signUp=findViewById(R.id.signupText);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"Login Successful", Toast.LENGTH_SHORT);
                toast.show();
                String uname=username.getText().toString();
                String upass=password.getText().toString();
                Log.i("uname", uname+" "+upass);
                if(uname.equals("admin")){
                    Intent i = new Intent(getApplicationContext(),Admin.class);
                    startActivity(i);
                }
                else{
                    Intent i = new Intent(getApplicationContext(),Home.class);
                    startActivity(i);
                }}
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toast=Toast.makeText(getApplicationContext(),"sign up", Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(getApplicationContext(),SignUp.class);
                startActivity(i);
            }
        });
    }

}