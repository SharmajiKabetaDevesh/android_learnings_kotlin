package com.example.pagedatapassing

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
import com.example.pagedatapassing.databinding.ActivityMainBinding
import com.example.pagedatapassing.ui.theme.PageDataPAssingTheme

class MainActivity : ComponentActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.butn.setOnClickListener{

            var i1=binding.item1.text.toString()
            var i2=binding.item2.text.toString()
            var i3=binding.item3.text.toString()
            var i4=binding.item4.text.toString()
            var order="Ordered just now : $i1 , $i2, $i3 , +$i4 " +
                    "will arrive soon"



            var intent= Intent(applicationContext,MainActivity2::class.java);
            intent.putExtra("Devesh",order);
            startActivity(intent)
        }





            }
        }

