package com.changzakso.dreamcatcher;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.changzakso.dreamcatcher.adapter.MonthListAdapter;
import com.changzakso.dreamcatcher.utils.CzToast;


public class ListActivity extends AppCompatActivity {
    MonthListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.list_title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView customList = (RecyclerView) findViewById(R.id.cMainListView);
        customList.setHasFixedSize(true);
        listAdapter = new MonthListAdapter(new MonthListAdapter.WordSelectListener() {
            @Override
            public void onSearchWord(String title) {
                CzToast.l(ListActivity.this, title);
                Intent i = new Intent(ListActivity.this, DetailActivity.class);
                startActivity(i);
            }
        });
        customList.setAdapter(listAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // API 5+ solution
                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}