package com.example.toolbaraction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
toolbar=findViewById(R.id.toolbar);
setSupportActionBar(toolbar);
if(getSupportActionBar()!=null) {
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle("Amazon");
}

toolbar.setSubtitle("Getting rid of shit");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemid=item.getItemId();
        if(itemid==R.id.opt_cart){
            Toast.makeText(this,"Cart OPened",Toast.LENGTH_LONG).show();
        }else if(itemid==R.id.opt_save){
            Toast.makeText(this,"Saved",Toast.LENGTH_LONG).show();
        }else if(itemid==R.id.opt_search){
            Toast.makeText(this,"Search for the products",Toast.LENGTH_LONG).show();
        }else if(itemid==android.R.id.home){
            super.onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}