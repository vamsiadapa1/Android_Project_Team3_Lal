package com.example.Endecryptmessanger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;


public class userInfo extends AppCompatActivity {

    TextView itemName, itemAge, itemGender, itemAdmin;
    FirebaseAuth mAuth;
    DatabaseReference readRef;
    DatabaseReference db;
    FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);


        itemName = findViewById(R.id.name);
        itemAge = findViewById(R.id.age);
        itemGender = findViewById(R.id.gender);
        itemAdmin = findViewById(R.id.admin);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        String age = i.getStringExtra("age");
        String gender = i.getStringExtra("gender");
        String admin = i.getStringExtra("admin");
        String blocked = i.getStringExtra("blocked");
        String userId = i.getStringExtra("id");


        itemName.setText("User: " + name);
        itemAge.setText("Age: " + age);
        itemGender.setText("Gender: " + gender);
        itemAdmin.setText("Admin: " + admin);


    }
}