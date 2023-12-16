package com.example.notificationpractise

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat


class MainActivity : ComponentActivity() {
    val channelid="devesh"
    val channeldesc="Sharma"
    val notificationid=987
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val butnotify=findViewById<Button>(R.id.Click)
        createNotificationChannel()

        //pending intent
        val intent= Intent(this,MainActivity2::class.java)
        val pendingIntent= PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_MUTABLE)

        val notification= NotificationCompat.Builder(this,channelid)
            .setSmallIcon(R.drawable.baseline_insert_emoticon_24)
            .setContentTitle("Mera pehla Pyar")
            .setContentText("Jindagi ek safar hai suhana ....")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()


        val notificationManager= NotificationManagerCompat.from(this)

        butnotify.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {

            }

            notificationManager.notify(notificationid,notification)
        }

    }


    private fun createNotificationChannel(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel= NotificationChannel(channelid,channeldesc, NotificationManager.IMPORTANCE_DEFAULT).apply {
                description="This is my first Notification"

            }
            //register the channel with the system
            val manager=getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}
