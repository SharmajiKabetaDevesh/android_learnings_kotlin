package com.example.photoframe

import android.os.Bundle
import androidx.activity.ComponentActivity

import com.example.photoframe.databinding.ActivityMainBinding


class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val changingtext=arrayOf("Ganpati Bappa Morya","APJ Abdul Kalam JI","Jai Shri Ram")
        val data = arrayOf("pic11", "pic12", "pic13")
        binding.forward.setOnClickListener {

            // Remove the modulo operation
            var point = counter % data.size
            var image = data[point]

            // Correct way to set the image
            var resourceId = resources.getIdentifier(image, "drawable", packageName)
            binding.imagechange.setImageResource(resourceId)
            binding.textchange.setText(changingtext[point])
            // Increment the counter for the next click
            counter++
        }
        binding.backward.setOnClickListener {

            // Remove the modulo operation
            var point = counter % data.size
            var image = data[point]

            // Correct way to set the image
            var resourceId = resources.getIdentifier(image, "drawable", packageName)
            binding.imagechange.setImageResource(resourceId)
            binding.textchange.setText(changingtext[point])
            // Increment the counter for the next click
            counter--
        }
    }
}


