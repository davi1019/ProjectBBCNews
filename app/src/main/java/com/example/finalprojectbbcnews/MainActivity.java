package com.example.finalprojectbbcnews;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Function;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem mhome, msports, mscience, mentertainment;
    PagerAdaptor pagerAdaptor;
    Toolbar mtoolbar;


   String API_KEY = "b0319e45fed846ba8d151cc29ff2d4c3";
   String NEWS_SOURCE = "BBC news";
   ListView listNews;
   ProgressBar loader;

   ArrayList<HashMap<String, String>> dataList = new ArrayList<>();
   static final String KEY_AUTHOR = "author";
   static final String KEY_TITLE = "title";
   static final String KEY_DESCRIPTION = "description";
   static final String KEY_URL = "url";
   static final String KEY_URLTOIMAGE = "urlToImage";
   static final String KEY_PUBLISHEDAT = "publishedAt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtoolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mtoolbar);

        mhome=findViewById(R.id.home);
        msports=findViewById(R.id.sports);
        mscience=findViewById(R.id.science);
        mentertainment=findViewById(R.id.entertainment);
        tabLayout=findViewById(R.id.included);

        pagerAdaptor=new PagerAdaptor(getSupportFragmentManager(),4);
        viewPager.setAdapter(pagerAdaptor);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()||3)
                {
                    pagerAdaptor.notifyDataSetChanged();
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        } );

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
