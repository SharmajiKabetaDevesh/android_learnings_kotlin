package com.example.databaseusingsqldatabaseconnection;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Databasecon database = new Databasecon(this);

        ArrayList<Struc> struc = database.getContacts();

        for (Struc contact : struc) {
            Log.d("Data", "ID: " + contact.id + ", Name: " + contact.name + ", Phone No.: " + contact.phoneno);
        }
    }
}

