package com.brandingbrand.tommcfarlin.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Window leak exception: fail to dismiss dialog before finishing activity
 */
public class WindowLeak1 extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window_leak_1);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MaterialDialog.Builder(WindowLeak1.this)
                        .content("Dialog")
                        .progress(true, 0)
                        .cancelable(false)
                        .show();
                finish();
            }
        });
    }
}
