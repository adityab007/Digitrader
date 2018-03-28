package com.example.dell.Digitrader;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Dell on 3/20/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<ViewHolder> {


    private List<User> users;


    public RecyclerAdapter(List<User> users){
        this.users = users;
    }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item,parent,false);//getting context fromm this viewgroup
            return new ViewHolder(view);//returning the created new view
        }



    @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            User sampleuser = users.get(position);
            holder.name1.setText(sampleuser.Barcode);
            holder.desc2.setText(sampleuser.ExpiryDate);
            holder.desc1.setText(sampleuser.Price);
            holder.name2.setText(sampleuser.ProductName);
            //holder.image.setImageResource(sampleuser.userimage);
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }

