package com.example.alarmmanagerlearn;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button btn;
EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn=findViewById(R.id.but);
        editText=findViewById(R.id.edttxt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


        int time = Integer.parseInt(editText.getText().toString());
        long trigger = System.currentTimeMillis()+(time*1000);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent icast =new Intent(MainActivity.this, myreceiver.class);
        PendingIntent pi = PendingIntent.getBroadcast(MainActivity.this,100,icast,PendingIntent.FLAG_UPDATE_CURRENT);
  alarmManager.set(AlarmManager.RTC_WAKEUP,trigger,pi);
            }
        });
    }
}