package com.example.dell.Digitrader;

import android.app.Application;

import com.google.firebase.database.FirebaseDatabase;

public class Digitrader extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        /*
        Picasso.Builder builder = new Picasso.Builder(this);
        builder.downloader(new OkHttpDownloader(this,Integer.MAX_VALUE));
        Picasso built = builder.build();
        built.setIndicatorEnabled(true);
        built.setLoggingEnabled(true);
        Picasso.setSingeltonInstance(built);*/
    }
}
