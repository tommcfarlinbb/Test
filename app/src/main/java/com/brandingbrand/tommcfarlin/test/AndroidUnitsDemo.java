package com.brandingbrand.tommcfarlin.test;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;


public class AndroidUnitsDemo extends AppCompatActivity implements View.OnClickListener {

    Spinner vTextSpinner;
    Spinner vViewSpinner;

    EditText vViewSize;
    EditText vTextSize;

    View vView;
    TextView vText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.density_examples);

        vTextSize = (EditText) findViewById(R.id.text_size);
        vViewSize = (EditText) findViewById(R.id.view_size);

        vView = (View) findViewById(R.id.view);
        vText = (TextView) findViewById(R.id.text);

        findViewById(R.id.view_submit).setOnClickListener(this);
        findViewById(R.id.text_submit).setOnClickListener(this);

        vViewSpinner = (Spinner) findViewById(R.id.view_spinner);
        vTextSpinner = (Spinner) findViewById(R.id.text_spinner);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dimensions, android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        vViewSpinner.setAdapter(adapter);
        vTextSpinner.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        final int value;
        final String dimension;

        switch (v.getId()) {
            case R.id.view_submit:

                value = Integer.valueOf(vViewSize.getText().toString());
                dimension = vViewSpinner.getSelectedItem().toString();

                vView.getLayoutParams().width = getPx(dimension, value);
                vView.requestLayout();

                break;
            case R.id.text_submit:

                value = Integer.valueOf(vTextSize.getText().toString());
                dimension = vTextSpinner.getSelectedItem().toString();

                vText.setTextSize(TypedValue.COMPLEX_UNIT_PX, getPx(dimension, value));
                vText.requestLayout();

                break;
        }
    }

    private int getPx(String dimension, int value) {
        switch (dimension) {
            case "dp":
                return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics());
            case "sp":
                return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, value, getResources().getDisplayMetrics());
            case "px":
                return value;
            default:
                return value;
        }
    }
}
