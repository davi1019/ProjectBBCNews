package com.example.finalprojectbbcnews;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    String API_KEY = "b0319e45fed846ba8d151cc29ff2d4c3";
    ArrayList<news_list>news_listArrayList;
    ListAdaptor adapter;
    String country="in";
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.homefragment,null);

        recyclerView=v.findViewById(R.id.recyclerviewofhome);
        news_listArrayList=new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new ListAdaptor(getContext(),news_listArrayList);
        recyclerView.setAdapter(adapter);

        findNews();
        return v;
    }

   private void findNews(){

        APIUtilities.getAPIInterface
    }
}
