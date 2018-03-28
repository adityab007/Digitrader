package com.example.dell.Digitrader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Main2Activity extends AppCompatActivity {


    public String value=new String();
    DatabaseReference databaseReference;
    EditText e1,e2,e3,e4;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        databaseReference = FirebaseDatabase.getInstance().getReference();


        e1 = findViewById(R.id.barcode);
        e2 = findViewById(R.id.productname);
        e3 = findViewById(R.id.price);
        e4 = findViewById(R.id.expirydate);


        value = getIntent().getStringExtra("key");
    }
        @Override
        protected void onStart() {
            super.onStart();

        ValueEventListener valueEventListener = databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if(dataSnapshot.hasChildren())
                    Toast.makeText(getApplicationContext(),"true" ,Toast.LENGTH_SHORT).show();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {

                    User data = dataSnapshot1.getValue(User.class);
                    // data2= Integer.parseInt(data.Barcode.replaceAll("[^0-9]",""));
                    //int data3 = Integer.parseInt(value.replaceAll("[^0-9]",""));
                    if(value.equals(data.Barcode))
                    {
                        e1.setText(""+data.Barcode);
                        e2.setText(""+data.ProductName);
                        e3.setText(""+data.Price);
                        e4.setText(""+data.ExpiryDate);
                    }
                    else
                    {

                    }
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
