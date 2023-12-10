package com.example.trialskotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import kotlinx.android.synthetic.main.activity_main.button
import com.example.trialskotlin.R.layout.activity_main as activity_main

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(/* layoutResID = */ activity_main)

        button.setOnClickListener {
            val next = Intent(applicationContext, MainActivity2::class.java)
            startActivity(next)
        }



    }
    }


