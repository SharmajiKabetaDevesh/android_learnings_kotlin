package com.example.intents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
Button but1,but2,but3,but4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        but1 = findViewById(R.id.but1);
        but2 = findViewById(R.id.but2);
        but3 = findViewById(R.id.but3);
        but4 = findViewById(R.id.but4);




        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
  Intent idial=new Intent(Intent.ACTION_DIAL);
  idial.setData(Uri.parse("tel: +917738874661"));
  startActivity(idial);
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent imsg = new Intent(Intent.ACTION_SENDTO);
imsg.setData(Uri.parse("smsto:"+Uri.encode("+917738874661")));
imsg.putExtra("sms_body","PLease help me regarding this topic");
startActivity(imsg);
            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent imail = new Intent(Intent.ACTION_SEND);
imail.setType("message/rfc822");
imail.putExtra(Intent.EXTRA_EMAIL,new String[]{"abc@gmail.com","deveshrs2016@gmail.com"});
imail.putExtra(Intent.EXTRA_SUBJECT,"Important do asap");
imail.putExtra(Intent.EXTRA_TEXT,"PLease help me with the new topic");
           startActivity(Intent.createChooser(imail,"Email via"));


            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
Intent ishare = new Intent(Intent.ACTION_SEND);
ishare.setType("text/plain");
ishare.putExtra(Intent.EXTRA_TEXT,"Enjoy your life mc");
startActivity(Intent.createChooser(ishare,"share via"));

            }
        });

    }
}