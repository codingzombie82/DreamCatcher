package com.changzakso.dreamcatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.changzakso.dreamcatcher.adapter.MonthListAdapter;
import com.changzakso.dreamcatcher.adapter.SearchWordAdapter;
import com.changzakso.dreamcatcher.utils.CzToast;

public class MainActivity extends AppCompatActivity {

    SearchWordAdapter gridAdapter;
    MonthListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        gridAdapter = new SearchWordAdapter(new SearchWordAdapter.WordSelectListener() {
            @Override
            public void onSearchWord(String title) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                startActivity(i);
            }
        });
        recyclerView.setAdapter(gridAdapter);


        RecyclerView customList = (RecyclerView) findViewById(R.id.cMonthListView);
        customList.setHasFixedSize(true);
        listAdapter = new MonthListAdapter(new MonthListAdapter.WordSelectListener() {
            @Override
            public void onSearchWord(String title) {
                CzToast.l(MainActivity.this, title);
                Intent i = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });
        customList.setAdapter(listAdapter);
    }


}