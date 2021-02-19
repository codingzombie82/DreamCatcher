package com.changzakso.dreamcatcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                movePermissionPage();
            }
        }, 1500);
    }

    private void movePermissionPage() {
        Intent intent = new Intent(SplashActivity.this, PermissionActivity.class);
        startActivity(intent);

        finish();
    }
}