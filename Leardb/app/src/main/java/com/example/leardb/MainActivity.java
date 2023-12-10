package com.example.leardb;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Database database = new Database(this);
       database.deletecontact(3);
        ArrayList<Struc> arrcon = database.getContacts();

        for (int i=0;i<arrcon.size();i++) {
            Log.d("Data",  " Name: " + arrcon.get(i).name + ", Phone No.: " + arrcon.get(i).phoneno);
        }
    }
}

