package com.example.buttons;

import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
Button but,but1;
TextView txt;
private static final String CHANNEL_ID="My Channel" ;
    private static final int nid=100 ;
    private static final int req=120 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Drawable drawable = ResourcesCompat.getDrawable(getResources(),R.drawable.anonymous_man,null);
        BitmapDrawable bitmapDrawable= (BitmapDrawable) drawable ;
        Bitmap largeicon=bitmapDrawable.getBitmap();
        Notification notification;

        Drawable drawable1 = ResourcesCompat.getDrawable(getResources(),R.drawable.o,null);
        BitmapDrawable bitmapDrawable1 = (BitmapDrawable) drawable1;
        Bitmap bitmap = bitmapDrawable1.getBitmap();



Intent intent= new Intent(getApplicationContext(),MainActivity.class);
intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pm = PendingIntent.getActivity(MainActivity.this,req,intent,PendingIntent.FLAG_UPDATE_CURRENT);
        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(bitmap)
                .bigLargeIcon(largeicon)
                .setBigContentTitle("Image Sent by Raman")
                .setSummaryText("Image Message");



        //Inbox style
        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("afdf")
                .addLine("fdf")
                .addLine("fsd")
                .addLine("gdfgdfg")
                .addLine("fdgfdg")
                .addLine("dfgvgf")
                .addLine("dfgfdg")
                .addLine("gfd")
                .addLine("gfdfz");

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(largeicon)
                    .setSmallIcon(R.drawable.o)
                    .setContentText("New MEssage")
                    .setSubText("New message from raman")
                    .setContentIntent(pm)
                    .setChannelId(CHANNEL_ID)
                    .setAutoCancel(false)
                    .setStyle(inboxStyle)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANNEL_ID,"nEW CHANNEL",NotificationManager.IMPORTANCE_HIGH));

        }else {
             notification = new Notification.Builder(this)
                    .setLargeIcon(largeicon)
                     .setAutoCancel(false)
                    .setSmallIcon(R.drawable.o)
                    .setContentText("New MEssage")
                     .setContentIntent(pm)
                     .setStyle(inboxStyle)
                    .setSubText("New message from raman")
                    .build();
        }
        nm.notify(nid,notification);

/*
        but = findViewById(R.id.but);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {







                /*
                Dialog dialog = new Dialog(MainActivity.this);
dialog.setContentView(R.layout.dialogue_custom);
dialog.setCancelable(false);
but1=dialog.findViewById(R.id.btn1);
but1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
        dialog.dismiss();
    }
});

dialog.show()*/
               /* AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("Terms and conditions");
                alertDialog.setIcon(R.drawable.baseline_airplanemode_active_24);
                alertDialog.setMessage("Have you read the conditions");
                alertDialog.setPositiveButton("Yes,I have read",new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Saved",Toast.LENGTH_LONG).show();
                    }
                });
                alertDialog.show();
               AlertDialog.Builder alertdialog = new AlertDialog.Builder(MainActivity.this);
                alertdialog.setTitle("Do you want to delete");
                alertdialog.setMessage("It will be deleted permanently");
alertdialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        Toast.makeText(MainActivity.this,"Deleted",Toast.LENGTH_LONG).show();
    }
});
                alertdialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Exited",Toast.LENGTH_LONG).show();
                    }
                });
                alertdialog.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"Laga hi tha ",Toast.LENGTH_LONG).show();
                    }
                });
                alertdialog.show();
*/
            }
        }
