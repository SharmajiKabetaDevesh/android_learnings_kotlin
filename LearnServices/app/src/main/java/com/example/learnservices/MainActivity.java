package com.example.learnservices;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btn1,btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1= findViewById(R.id.startbut);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
startService(new Intent(MainActivity.this,Musicservice.class));
            }
        });


        btn2=findViewById(R.id.stopbut);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(new Intent(MainActivity.this,Musicservice.class));
            }
        });
    }
}