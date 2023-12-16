package com.example.photoframe

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.photoframe.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    var currentImage=0
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}

