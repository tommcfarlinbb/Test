package com.brandingbrand.tommcfarlin.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Bad token exception: show dialog while finishing
 */
public class NoLeakScenario1 extends AppCompatActivity {

    MaterialDialog md;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.no_leak_scenario_1);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NoLeakScenario1.this, BlankActivity.class));
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        md.show();
                    }
                }, 1000);
            }
        });

        md = new MaterialDialog.Builder(this)
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
