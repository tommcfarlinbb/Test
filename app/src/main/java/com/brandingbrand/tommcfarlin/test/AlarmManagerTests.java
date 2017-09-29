package com.brandingbrand.tommcfarlin.test;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.EditText;

import com.afollestad.materialdialogs.MaterialDialog;

/**
 * Window leak exception: fail to dismiss dialog before finishing activity
 */
public class AlarmManagerTests extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_manager_test);
        findViewById(R.id.add_alarm).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, NotificationBroadcastReceiver.class);
        intent.putExtra("ID", Integer.parseInt(((EditText) findViewById(R.id.alarm_id)).getText().toString()));
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, 0);
        switch (v.getId()) {
            case R.id.add_alarm:
                manager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, Long.parseLong(((EditText) findViewById(R.id.alarm_offset)).getText().toString()), pendingIntent);
                break;
            case R.id.remove_alarm:
                manager.cancel(pendingIntent);
                break;
        }
    }
}
