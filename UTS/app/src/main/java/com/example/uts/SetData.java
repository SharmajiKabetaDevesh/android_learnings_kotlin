package com.example.uts;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SetData extends AppCompatActivity {
    EditText source, destination, time;
    Button savebut, clear;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_data);
        sharedPreferences = getSharedPreferences("TicketData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        source = findViewById(R.id.source);
        destination = findViewById(R.id.destination);
        time = findViewById(R.id.time);
        savebut = findViewById(R.id.savebut); // Initialize the savebut button
        clear = findViewById(R.id.clear); // Initialize the clear button

        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sc = source.getText().toString();
                String dest = destination.getText().toString();
                String tim = time.getText().toString();

                if (sc != null && dest != null && tim != null) {
                    editor.putString("from", sc);
                    editor.putString("to", dest);
                    editor.putString("Time", tim);
                    editor.apply();
                }
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.clear();
                editor.apply();
            }
        });
    }
}
