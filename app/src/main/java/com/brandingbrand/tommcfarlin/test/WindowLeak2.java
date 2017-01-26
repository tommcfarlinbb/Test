package com.brandingbrand.tommcfarlin.test;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Bad token exception: show dialog while finishing
 */
public class WindowLeak2 extends AppCompatActivity {

    MaterialDialog md;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.window_leak_2);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        md =new MaterialDialog.Builder(this)
                .content("Dialog")
                .progress(true, 0)
                .cancelable(false)
                .build();
    }

    @Override
    protected void onPause() {
        super.onPause();
        md.show();
    }
}
