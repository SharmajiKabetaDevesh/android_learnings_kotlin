package com.example.d1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.d1.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding:ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

       val e=intent.getStringExtra("email")
        val n=intent.getStringExtra("name")
        val u=intent.getStringExtra("userId")

        binding.txt1.text=e
        binding.txt2.text =n
        binding.txt3.text =u

    }
}