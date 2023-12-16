package com.example.cartoonmaker

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)


        android.os.Handler().postDelayed({
            val intent= Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)
        },4000)


    }
}

