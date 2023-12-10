package com.example.quicko;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.widget.RemoteViews;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.ContextCompat;

public class PersistentNotificationService extends Service {
    private static final int CHANNEL_ID = 2;
    private static final int notificationId = 1;
    private static final int PERMISSION_REQUEST_CODE = 3;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
// INitializing the notification components

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, String.valueOf(CHANNEL_ID))
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setOngoing(true)
                .setContentTitle("QuickO")
                .setContentText("Saved Some Earned Some")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        NotificationManagerCompat notificationmanager = NotificationManagerCompat.from(this);

        //CReate a custom layout
        RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.cutom_notification);
        builder.setCustomContentView(remoteViews);

        // Setup button click actions
        //Button1
        Intent button1Intent = new Intent(this, AlarmReceiver.class);
        button1Intent.setAction("SET_ALARM_1");
        PendingIntent pendingButton1Intent = PendingIntent.getBroadcast(this, 0, button1Intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Button 2

        Intent button2Intent = new Intent(this, AlarmReceiver.class);
        button2Intent.setAction("SET_ALARM_2");
        PendingIntent pendingButton2Intent = PendingIntent.getBroadcast(this, 1, button2Intent, PendingIntent.FLAG_UPDATE_CURRENT);

        //Button 3

        Intent button3Intent = new Intent(this, AlarmReceiver.class);
        button2Intent.setAction("SET_ALARM_2");
        PendingIntent pendingButton3Intent = PendingIntent.getBroadcast(this, 1, button2Intent, PendingIntent.FLAG_UPDATE_CURRENT);

        remoteViews.setOnClickPendingIntent(R.id.button1, pendingButton1Intent);
        remoteViews.setOnClickPendingIntent(R.id.button2, pendingButton2Intent);
        remoteViews.setOnClickPendingIntent(R.id.button3, pendingButton3Intent);

        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            // Permission not granted, request it from the user
            try {
                ActivityCompat.requestPermissions(MainActivity2.class.newInstance(), new String[]{android.Manifest.permission.POST_NOTIFICATIONS}, PERMISSION_REQUEST_CODE);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
        } else {
            // Permission is granted, proceed with creating and showing the notification
            // ...
        }


        notificationmanager.notify(notificationId, builder.build());

        return START_STICKY;


    }
    @Override
    public void onDestroy(){
        super.onDestroy();

    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
