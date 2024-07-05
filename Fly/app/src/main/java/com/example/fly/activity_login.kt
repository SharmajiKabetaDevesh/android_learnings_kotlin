package com.example.fly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.example.fly.databinding.ActivityAcitivityLoginBinding
import com.example.fly.databinding.ActivitySignupBinding

class acitivity_login : AppCompatActivity() {
    lateinit var binding:ActivityAcitivityLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityAcitivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signupButton.setOnClickListener {
            val intent= Intent(this,ActivitySignupBinding::class.java)
            startActivity(intent)
        }


    }
}