package com.example.uts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketAct extends AppCompatActivity {
TextView From,To,Date,Time;
Button butdetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);
        From=findViewById(R.id.From);
        To=findViewById(R.id.To);
        Date = findViewById(R.id.Date);
        butdetail = findViewById(R.id.butdetail);



        // Get the current date
        java.util.Date currentDate = new Date();

// Create a SimpleDateFormat object to format the date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

// Format the date to "Day/Month/Year" format
        String formattedDate = sdf.format(currentDate);

// Now 'formattedDate' will contain the current date in the desired format





        SharedPreferences sharedPreferences= getSharedPreferences("TicketData", Context.MODE_PRIVATE);
        String from = sharedPreferences.getString("from","");
String to = sharedPreferences.getString("to","");
String time = sharedPreferences.getString("Time","");
From.setText(from);
To.setText(to);
        Date.setTextColor(Color.rgb(225,158 , 100));
Date.setText(formattedDate +"   "+time);


        Intent intent = new Intent(this, Detailsabtticket.class);

butdetail.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
startActivity(intent);
    }
});



    }
}