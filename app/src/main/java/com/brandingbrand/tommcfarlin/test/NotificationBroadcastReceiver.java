package com.brandingbrand.tommcfarlin.test;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.widget.EditText;


public class NotificationBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager mNotificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
// Sets an ID for the notification, so it can be updated

        NotificationCompat.Builder mNotifyBuilder = new NotificationCompat.Builder(context)
                .setContentTitle("New Message")
                .setSmallIcon(R.drawable.black_circle)
                .setContentText("You've received new messages.");
        mNotifyBuilder.build();

        String currentText = "Test";
        mNotifyBuilder.setContentText(currentText);
        mNotificationManager.notify(
                intent.getIntExtra("ID", (int) (1000 * Math.random())),
                mNotifyBuilder.build());
    }
}
