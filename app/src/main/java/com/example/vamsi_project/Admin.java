package com.example.vamsi_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Admin extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private AdminAdapter  mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<AdminItem> UserItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);



        UserItem =new ArrayList<>();
        UserItem.add(new AdminItem("Sam","Blocked:False"));
        UserItem.add(new AdminItem("Mike","Blocked:True"));
        UserItem.add(new AdminItem("John","Blocked:False"));
        UserItem.add(new AdminItem("Tarun","Blocked:False"));
        UserItem.add(new AdminItem("Beber","Blocked:False"));
        UserItem.add(new AdminItem("Justin","Blocked:False"));
        UserItem.add(new AdminItem("Vamsi","Blocked:False"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdminAdapter(UserItem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        RecyclerView rv=findViewById(R.id.recyclerView);
        mAdapter.setOnItemClickListener(new AdminAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast toast=Toast.makeText(getApplicationContext(),"clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdminAdapter(UserItem);


        mAdapter.setOnItemClickListener(new AdminAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast toast=Toast.makeText(getApplicationContext(),"clicked", Toast.LENGTH_SHORT);
                toast.show();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu2, menu);

        MenuItem userInfo = menu.findItem(R.id.action_user_info);
        MenuItem logoutItem=menu.findItem(R.id.action_logout);

        userInfo.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                Intent i = new Intent(getApplicationContext(), userInfo.class);
                startActivity(i);
                return false;
            }
        });

        logoutItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(@NonNull MenuItem menuItem) {
                FirebaseAuth.getInstance().signOut();
                Intent i=new Intent(getApplicationContext(),LoginPage.class);
                startActivity(i);
                finish();
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);

    }

}
