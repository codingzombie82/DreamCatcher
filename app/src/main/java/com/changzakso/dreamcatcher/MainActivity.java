package com.changzakso.dreamcatcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.changzakso.dreamcatcher.adapter.MonthListAdapter;
import com.changzakso.dreamcatcher.adapter.SearchWordAdapter;
import com.changzakso.dreamcatcher.utils.CzToast;

public class MainActivity extends AppCompatActivity {

    SearchWordAdapter gridAdapter;
    MonthListAdapter listAdapter;
    EditText etWord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etWord = findViewById(R.id.etWord);
        findViewById(R.id.btSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etWord.getText().length() > 0){
                    Intent i = new Intent(MainActivity.this, ListActivity.class);
                    String word = etWord.getText().toString();
                    i.putExtra(Intent.EXTRA_TEXT, word);
                    startActivity(i);
                }else{
                    CzToast.s(MainActivity.this, "검색어를 입력하세요");
                }
            }
        });


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        gridAdapter = new SearchWordAdapter(new SearchWordAdapter.WordSelectListener() {
            @Override
            public void onSearchWord(String title) {
                Intent i = new Intent(MainActivity.this, ListActivity.class);
                i.putExtra(Intent.EXTRA_TEXT, title);
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

    @Override
    protected void onResume() {
        super.onResume();
        etWord.setText("");
    }
}