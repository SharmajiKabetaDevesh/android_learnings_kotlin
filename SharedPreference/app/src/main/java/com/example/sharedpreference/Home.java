package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
Button butLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        butLogout =findViewById(R.id.ButLogout);
        butLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
            SharedPreferences.Editor editor=pref.edit();
            editor.putBoolean("flag",false);
                editor.apply();
             Intent inext = new Intent(Home.this, Login.class);
             startActivity(inext);



            }
        });

    }
}