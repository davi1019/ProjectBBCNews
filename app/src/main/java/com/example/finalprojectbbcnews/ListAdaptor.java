package com.example.finalprojectbbcnews;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class ListAdaptor extends RecyclerView.Adapter<ListAdaptor.ViewHolder> {

    Context context;
    ArrayList<news_list> news_listArrayList;

    public ListAdaptor(Context context, ArrayList<news_list> news_listArrayList) {
        this.context = context;
        this.news_listArrayList = news_listArrayList;
    }

    @Override
    public ListAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, null,false);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdaptor.ViewHolder holder, int position){
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,webView.class);
                intent.putExtra("url",news_listArrayList.get(position).getUrl());
                context.startActivity(intent);
            }
        });

        holder.mauthor.setText(news_listArrayList.get(position).getAuthor());
        holder.mheading.setText(news_listArrayList.get(position).getTitle()));
        holder.mdescription.setText(news_listArrayList.get(position).getDescription());
        Glide.with(context).load(news_listArrayList.get(position).getUrlToImage()).into(holder.imageView);

    }
    @Override
    public int getItemCount(){
        return news_listArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mheading,mcontent, mauthor, mdescription;
        CardView cardView;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mheading=itemView.findViewById(R.id.text_title);
            mcontent=itemView.findViewById(R.id.text_source);
            mauthor=itemView.findViewById(R.id.author);
            mdescription=itemView.findViewById(R.id.description);
            imageView=itemView.findViewById(R.id.image_view);
            cardView=itemView.findViewById(R.id.cardview);
        }
    }
}