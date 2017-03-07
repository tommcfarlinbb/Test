package com.brandingbrand.tommcfarlin.test;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        findViewById(R.id.dialog_exceptions).setOnClickListener(this);
        findViewById(R.id.dialog_examples).setOnClickListener(this);
        findViewById(R.id.android_units_demo).setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dialog_exceptions:
                startActivity(new Intent(this, DialogExceptions.class));
            case R.id.dialog_examples:
                startActivity(new Intent(this, DialogExamples.class));
            case R.id.android_units_demo:
                startActivity(new Intent(this, AndroidUnitsDemo.class));
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
