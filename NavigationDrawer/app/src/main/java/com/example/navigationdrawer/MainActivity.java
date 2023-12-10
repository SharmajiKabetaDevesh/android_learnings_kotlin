package com.example.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bnview;
    FrameLayout fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bnview = findViewById(R.id.bottomnav);
        bnview.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.first) {
                    load(new AFragment(), 0);
                } else if (id == R.id.second) {
                    load(new BFragment(), 1);
                } else if (id == R.id.third) {
                    load(new CFragment(), 2);
                } else if (id == R.id.fourth) {
                    load(new DFragment(), 3);
                }
                return true;
            }
        });
        bnview.setSelectedItemId(R.id.third);
    }

    public void load(Fragment fragment, int position) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (position == 0) {
            ft.replace(R.id.container, fragment);
        } else {
            ft.add(R.id.container, fragment);
        }
        ft.commit();
    }
}


    