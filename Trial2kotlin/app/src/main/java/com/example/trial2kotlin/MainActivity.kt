package com.example.trial2kotlin

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
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
import kotlinx.android.synthetic.main.activity_main.cardcamera
import kotlinx.android.synthetic.main.activity_main.cardweb


import com.example.trial2kotlin.R.layout.activity_main as activity_main1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContentView(activity_main1);
        cardweb.setOnClickListener{
                     val web=Intent(Intent.ACTION_VIEW)
            web.data= Uri.parse("https://github.com/SharmajiKabetaDevesh/android_learnings_kotlin/tree/master/UTS/app")
            startActivity(web)

        }

        cardcamera.setOnClickListener{
val intent = Intent(applicationContext,MainActivity2::class.java)
            startActivity(intent);
        }


    }
}

