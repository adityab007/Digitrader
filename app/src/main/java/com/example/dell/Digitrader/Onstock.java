package com.example.dell.Digitrader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Onstock extends AppCompatActivity {

    DatabaseReference databaseReference;
    RecyclerView recyclerView;
    public static int count=0;

    public static List<User> dataList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onstock);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.keepSynced(true);
        dataList = new ArrayList<>();
        recyclerView =findViewById(R.id.recycler_id);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(Onstock.this);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setHasFixedSize(true);


    }

    @Override
    protected void onStart() {
        super.onStart();
        ValueEventListener valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                dataList.clear();
                if(dataSnapshot.hasChildren())
                    Toast.makeText(getApplicationContext(),"true" ,Toast.LENGTH_SHORT).show();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    User data = dataSnapshot1.getValue(User.class);
                    count++;
                    dataList.add(data);
                }

                recyclerView.setAdapter(new RecyclerAdapter(dataList));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
