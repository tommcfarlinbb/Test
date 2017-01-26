package com.brandingbrand.tommcfarlin.test;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;


public class DialogExceptions extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_exceptions);

        findViewById(R.id.bad_token_1).setOnClickListener(this);
        findViewById(R.id.window_leak_1).setOnClickListener(this);
        findViewById(R.id.window_leak_2).setOnClickListener(this);

        setTextHtml((TextView) findViewById(R.id.bad_token_1_stack_trace), getString(R.string.bad_token_1_stack_trace));
        setTextHtml((TextView) findViewById(R.id.window_leak_1_stack_trace), getString(R.string.window_leak_1_stack_trace));
        setTextHtml((TextView) findViewById(R.id.window_leak_2_stack_trace), getString(R.string.window_leak_2_stack_trace));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bad_token_1:
                startActivity(new Intent(this, BadToken1.class));
                break;
            case R.id.window_leak_1:
                startActivity(new Intent(this, WindowLeak1.class));
                break;
            case R.id.window_leak_2:
                startActivity(new Intent(this, WindowLeak2.class));
                break;
        }
    }

    public static void setTextHtml(TextView tv, CharSequence text) {
        if (Build.VERSION.SDK_INT < 24) {
            tv.setText(Html.fromHtml(text.toString()));
        } else {
            tv.setText(Html.fromHtml(text.toString(), 0));
        }
    }
}
