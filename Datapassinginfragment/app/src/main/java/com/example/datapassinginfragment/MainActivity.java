package com.example.datapassinginfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.provider.DocumentsContract;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
Button but1,but2,but3;
FrameLayout container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        but1 = findViewById(R.id.But1);
        but2 = findViewById(R.id.But2);
        but3 = findViewById(R.id.But3);
        load(new AFragment(),0);
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load(new AFragment(),0);
            }
        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load(new BFragment(),1);
            }
        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                load(new CFragment(),1);
            }
        });

    }

    public void load(Fragment fragment,int po){
        FragmentManager fm =getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(po==0){
            ft.add(R.id.conrtainer,fragment);
            fm.popBackStack("AFragment",FragmentManager.POP_BACK_STACK_INCLUSIVE);
ft.addToBackStack("AFragment");



        }else{
            ft.replace(R.id.conrtainer,fragment);
            ft.addToBackStack(null);
        }


        ft.commit();
    }



}