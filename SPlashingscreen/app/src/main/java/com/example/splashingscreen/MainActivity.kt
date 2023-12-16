package com.example.splashingscreen

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.splashingscreen.databinding.ActivityMainBinding
import com.example.splashingscreen.ui.theme.SPlashingScreenTheme

class MainActivity : ComponentActivity() {
lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

       Handler().postDelayed({
           val intent= Intent(applicationContext,MainActivity2::class.java)
           startActivity(intent)
       },3000)


    }
}

