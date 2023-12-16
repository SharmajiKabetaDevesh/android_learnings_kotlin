package com.example.contactsaver

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import com.example.contactsaver.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : ComponentActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)


        Handler().postDelayed({
                              val intent= Intent(this,MainActivity2::class.java)
            startActivity(intent)
        },3000)


    }
}

