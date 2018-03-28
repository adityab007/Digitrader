package com.example.dell.Digitrader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Database extends AppCompatActivity {

    private EditText Barcode,ExpiryDate,Price,ProductName;
    private Button submit;
    private Button show;
    int a,b;
    FirebaseUser user;
    FirebaseAuth auth;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        Barcode =(EditText) findViewById(R.id.edit_Barcode);
        ProductName =(EditText) findViewById(R.id.edit_productname);
        Price =(EditText) findViewById(R.id.edit_price);
        ExpiryDate =(EditText) findViewById(R.id.edit_expiry);
        submit=(Button) findViewById(R.id.submit);
        show=(Button) findViewById(R.id.show);
        auth =FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        databaseReference.keepSynced(true);
    }



    public void submitData(View view)
    {
        String a1 = Barcode.getText().toString();
        String a2= ProductName.getText().toString();
        String a3= Price.getText().toString();
        String a4= ExpiryDate.getText().toString();
        int cnt =Onstock.count+1;

        if(!TextUtils.isEmpty(a1) && !TextUtils.isEmpty(a2) && !TextUtils.isEmpty(a3) && !TextUtils.isEmpty(a4))
        {
            //String id = databaseReference.push().getKey();
            databaseReference.child(""+cnt).child("Barcode").setValue(a1);
            databaseReference.child(""+cnt).child("ProductName").setValue(a2);
            databaseReference.child(""+cnt).child("Price").setValue(a3);
            databaseReference.child(""+cnt).child("ExpiryDate").setValue(a4);
            Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).show();
            Onstock.count=0;
            cnt=0;
        }
        else
        {
            Toast.makeText(this,"Enter all the marks", Toast.LENGTH_LONG).show();
        }

    }

    public  void showData(View view)
    {
        startActivity(new Intent(getApplicationContext(),Onstock.class));
    }
}
