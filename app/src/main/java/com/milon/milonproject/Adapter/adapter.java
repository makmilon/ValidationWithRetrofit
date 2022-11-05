package com.milon.milonproject.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.milon.milonproject.Model.ObjectDataClass;
import com.milon.milonproject.R;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<adapter.myholder> {

    ArrayList<ObjectDataClass> objectList;

    public adapter(ArrayList<ObjectDataClass> objectList) {
        this.objectList = objectList;
    }

    @NonNull
    @Override
    public myholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        return new myholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myholder holder, int position) {
          holder.name.setText(objectList.get(position).getOriginal_title());
          holder.realase.setText(objectList.get(position).getRelease_date());
          holder.rating.setText(objectList.get(position).getOriginal_title());
         Glide.with(holder.name.getContext())
                .load("https://image.tmdb.org/t/p/w500/"+objectList.get(position).getPoster_path())
                .into(holder.img);


    }

    @Override
    public int getItemCount() {
        return objectList.size();
    }

    class myholder extends RecyclerView.ViewHolder{

        TextView name, realase, rating;
        ImageView img;

        public myholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.item_name);
            realase=itemView.findViewById(R.id.item_realase);
            rating=itemView.findViewById(R.id.item_rating);

            img=itemView.findViewById(R.id.item_img);
        }
    }
}
