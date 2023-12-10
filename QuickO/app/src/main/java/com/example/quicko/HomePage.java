package com.example.quicko;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        boolean isPermissionGranted = sharedPreferences.getBoolean("isPermissionGranted", false);


if(!isPermissionGranted) {
    Intent intent = new Intent(this, permissions.class);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(intent);
        }
    }, 5000);
}else{
    Intent intentact =new Intent(this, MainActivity2.class);
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(intentact);
        }
    }, 2000);


}

    }@Override
    public void onBackPressed() {
        // Do nothing to disable the back button
    }

}