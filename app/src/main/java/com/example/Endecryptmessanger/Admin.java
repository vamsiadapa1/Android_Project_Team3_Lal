package com.example.Endecryptmessanger;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Admin extends AppCompatActivity {


    private RecyclerView mRecyclerView;
    private AdminAdapter  mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public ArrayList<AdminItem> UserItem;

    public DatabaseReference databaseReference;
    FirebaseUser firebaseUser;
    FirebaseAuth auth;


//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//       FirebaseUser currentUser = auth.getCurrentUser();
//        if(currentUser == null){
//            Intent i=new Intent(getApplicationContext(),LoginPage.class);
//            startActivity(i);
//            finish();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        databaseReference= FirebaseDatabase.getInstance().getReference("Registered Users");
        auth=FirebaseAuth.getInstance();
//        firebaseUser =auth.getCurrentUser();



        UserItem =new ArrayList<>();

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdminAdapter(UserItem);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



        RecyclerView rv=findViewById(R.id.recyclerView);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){
                        String id=dataSnapshot.getKey().toString();
//                    Toast.makeText(Admin.this, id, Toast.LENGTH_SHORT).show();
                        ReadWriteUserDetails user=dataSnapshot.getValue(ReadWriteUserDetails.class);
                        UserItem.add(new AdminItem(user.name,user.age,user.gender,user.admin+"",id));


                }
//                progressBar.setVisibility(View.GONE);
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        mAdapter.setOnItemClickListener(new AdminAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position){
                Intent i=new Intent(getApplicationContext(),userInfo.class);
                i.putExtra("name",UserItem.get(position).getItemName());
                i.putExtra("age",UserItem.get(position).getItemAge());
                i.putExtra("gender",UserItem.get(position).getItemGender());
                i.putExtra("admin",UserItem.get(position).getItemAdmin());
                i.putExtra("id",UserItem.get(position).getItemUserId());
                startActivity(i);
//                finish();
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

        MenuItem logoutItem=menu.findItem(R.id.action_logout);
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