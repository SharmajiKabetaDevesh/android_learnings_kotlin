package com.example.assignment

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity

import com.example.assignment.databinding.ActivityMainBinding
import com.example.assignment.ui.theme.MainActivity2

class MainActivity : ComponentActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        binding.butn1.setOnClickListener{
            val intent= Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}

