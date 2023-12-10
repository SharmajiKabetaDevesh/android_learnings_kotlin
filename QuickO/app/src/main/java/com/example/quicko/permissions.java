package com.example.quicko;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class permissions extends AppCompatActivity {
Button allowbut,dontallowbut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);

        allowbut=  findViewById(R.id.allowbut);
        dontallowbut=findViewById(R.id.dontallowbut);

allowbut.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        // Assuming this code is inside the onClickListener for the permission-granting button
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("isPermissionGranted", true);
        editor.apply();
        Intent intentact =new Intent(permissions.this, MainActivity2.class);
        startActivity(intentact);
    }
});

dontallowbut.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Toast.makeText(permissions.this,"This is mandtory for the apk",Toast.LENGTH_LONG);
    }
});


    }
}