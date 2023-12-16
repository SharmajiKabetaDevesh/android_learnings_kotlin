package com.example.assignment.ui.theme

import android.content.Intent
import android.net.Uri

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.assignment.R
import com.example.assignment.databinding.ActivityMain2Binding



class MainActivity2 : AppCompatActivity() {
    lateinit var binding:ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)

        binding.butn1.setOnClickListener{
            val intent1 =Intent(applicationContext,Act1::class.java)
            startActivity(intent1)
        }
        binding.butn2.setOnClickListener{
            val intent2 =Intent(applicationContext,Act2::class.java)
            startActivity(intent2)
        }
        binding.butn3.setOnClickListener{
            val intent3 =Intent(applicationContext,Act3::class.java)
            startActivity(intent3)
        }
        binding.butn4.setOnClickListener{
            val intent4 =Intent(applicationContext,Act4::class.java)
            startActivity(intent4)
        }
        binding.butn5.setOnClickListener{
            val intent5 =Intent(applicationContext,Act5::class.java)
            startActivity(intent5)
        }
        binding.butn6.setOnClickListener{
            val intent6 =Intent(applicationContext,Act6::class.java)
            startActivity(intent6)
        }

   binding.CallMe.setOnClickListener{
       val intent=Intent(Intent.ACTION_DIAL)
       intent.data = Uri.parse("tel:"+"7738874661")
       startActivity(intent)

   }
    }


}