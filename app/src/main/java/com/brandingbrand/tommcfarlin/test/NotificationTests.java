package com.brandingbrand.tommcfarlin.test;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NotificationTests extends AppCompatActivity {

    public static final String CHANNEL_FLASHING = "flashing";

    private int mNumberOfFlashes = 0;
    private NotificationChannel notificationChannel;
    private NotificationChannel notificationChannelSecondary;
    private Handler h = new Handler();

    private String youreBeingHacked = "You've been hacked.......MUAHAHAHAHAHA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_tests);
        final NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notificationChannel = new NotificationChannel(CHANNEL_FLASHING,
                    "Flashing", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setShowBadge(true);
            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        findViewById(R.id.flashingNotification).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        view.setEnabled(false);
                        final Runnable r = new Runnable() {
                            @Override
                            public void run() {
                                if (notificationManager != null) {
                                    if (mNumberOfFlashes++ < youreBeingHacked.length()) {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                            notificationChannel = new NotificationChannel("flashing" + mNumberOfFlashes,
                                                    "Flashing" + mNumberOfFlashes, NotificationManager.IMPORTANCE_HIGH);
                                            notificationChannel.enableLights(true);
                                            notificationChannel.setLightColor(Color.RED);
                                            notificationChannel.setShowBadge(true);
                                            notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                                            notificationManager.createNotificationChannel(notificationChannel);
                                            Notification n = getFlashingNotification(mNumberOfFlashes % 2 == 0 ? Color.RED : Color.GREEN, mNumberOfFlashes == 0, mNumberOfFlashes, notificationChannel);
                                            notificationManager.notify(1, n);
                                        }
                                        h.postDelayed(this, 100);
                                    } else {
                                        mNumberOfFlashes = 0;
                                        view.setEnabled(true);
                                    }
                                }
                            }
                        };
                        r.run();
                    }
                }
        );
    }

    private Notification getFlashingNotification(int color, boolean sound, int index, NotificationChannel notificationChannel) {

        NotificationCompat.Builder builder = new NotificationCompat.Builder(NotificationTests.this, notificationChannel.getId())
                .setContentTitle(youreBeingHacked.substring(0, index))
                .setSmallIcon(R.drawable.md_btn_selected)
                .setContentText("Body")
                .setAutoCancel(true);
        notificationChannel.setLightColor(color);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder.setColor(color);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                builder.setColorized(true);
            }
        }

        return builder.build();
    }
}
