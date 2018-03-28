package com.example.dell.Digitrader;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Dell on 3/20/2018.
 */

public class ViewHolder extends RecyclerView.ViewHolder{
    public ImageView image;
    public TextView name1,desc1,name2,desc2;
    public ViewHolder(View itemView) {
        super(itemView);

        //image = (ImageView)itemView.findViewById(R.id.imageview_id);
        name1 =  itemView.findViewById(R.id.name_textview);
        desc1 =  itemView.findViewById(R.id.desc_textview);
        desc2 =itemView.findViewById(R.id.desc_textview2);
        name2=itemView.findViewById(R.id.name_textview2);
    }
}
