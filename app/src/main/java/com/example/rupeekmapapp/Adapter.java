package com.example.rupeekmapapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.rupeekmapapp.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    LayoutInflater layoutInflater;
    List<Places> places;

    public Adapter(Context ctx, List<Places> places)
    {
        this.layoutInflater = LayoutInflater.from(ctx);
        this.places = places;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.cardesign,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(places.get(position).getName());
        holder.address.setText(places.get(position).getAddress());
        Picasso.get().load(places.get(position).getImageurl()).into(holder.image);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(this, MapActivity.class);
//                intent.putExtra("latitude", places.get(position).getLatitude());
//                intent.putExtra("longitude", places.get(position).getLongitude());
//                startActivity(intent); // start Intent
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView name,address;
        ImageView image;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            address = itemView.findViewById(R.id.address);
            image = itemView.findViewById(R.id.image);
        }
    }
}
