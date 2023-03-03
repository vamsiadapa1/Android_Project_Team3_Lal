package com.example.vamsi_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void aes(View view)
    {
        Intent intent = new Intent( Home.this, AES.class  );
        startActivity(intent);
    }
    public void des(View view)
    {
        Intent intent = new Intent( Home.this, DES.class  );
        startActivity(intent);
    }
    public void rsa(View view)
    {
        Intent intent = new Intent( Home.this, RSA.class  );
        startActivity(intent);
    }
    public void md5(View view)
    {
        Intent intent = new Intent( Home.this, MD5.class  );
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);


        MenuItem AboutItem = menu.findItem(R.id.action_about_app);
        MenuItem ContactItem = menu.findItem(R.id.action_contact_us);
        MenuItem PassItem = menu.findItem(R.id.action_password_reset);


        AboutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(), About_Us.class);
                startActivity(i);
                return false;
            }
        });


        ContactItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(), ContactUs.class);
                startActivity(i);
                return false;
            }
        });

        PassItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(), Resetpassword.class);
                startActivity(i);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }
}