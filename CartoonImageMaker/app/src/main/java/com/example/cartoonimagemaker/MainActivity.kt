package com.example.cartoonimagemaker

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.os.Handler


@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_main)


        Handler().postDelayed({
   val intent= Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent)

        },4000)

    }
}

