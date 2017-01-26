package com.brandingbrand.tommcfarlin.test;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Bad token exception: show dialog when activity has been destroyed
 */
public class BadToken1 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bad_token_1);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        new MaterialDialog.Builder(BadToken1.this)
                                .content("Dialog")
                                .progress(true, 0)
                                .cancelable(false)
                                .show();
                    }
                }, 2000);
            }
        });
    }
}
