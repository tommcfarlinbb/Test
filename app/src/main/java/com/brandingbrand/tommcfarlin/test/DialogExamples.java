package com.brandingbrand.tommcfarlin.test;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;


public class DialogExamples extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_examples);

        findViewById(R.id.alert).setOnClickListener(this);
        findViewById(R.id.material).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.alert:
                new AlertDialog.Builder(this)
                        .setTitle(R.string.title)
                        .setMessage(R.string.message)
                        .setNeutralButton(R.string.dismiss, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .show();
                break;
            case R.id.material:
                new MaterialDialog.Builder(this)
                        .title(R.string.title)
                        .content(R.string.message)
                        .neutralText(R.string.dismiss)
                        .show();
                break;
        }
    }
}
