package com.example.trial2kotlin

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.trial2kotlin.ui.theme.Trial2KotlinTheme

import kotlinx.android.synthetic.main.activity_main.mylayout

import androidx.core.content.ContextCompat;
import kotlinx.android.synthetic.main.activity_main.imageView

import com.example.trial2kotlin.R.layout.activity_main as activity_main1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContentView(activity_main1);
        imageView.setOnClickListener{
            val next=Intent(applicationContext,MainActivity2::class.java)
            startActivity(next);
        }


    }
}

