package com.example.alarmmanagerlearn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.provider.Settings;

public class myreceiver extends BroadcastReceiver {
    MediaPlayer mp = new MediaPlayer();


    @Override
    public void onReceive(Context context, Intent intent) {
    mp=MediaPlayer.create(context, Settings.System.DEFAULT_RINGTONE_URI);
    mp.setLooping(true);
    mp.start();
    }
}
