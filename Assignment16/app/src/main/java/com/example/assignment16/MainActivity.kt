package com.example.assignment16

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.assignment16.databinding.ActivityMainBinding
import com.example.assignment16.ui.theme.Assignment16Theme
import com.example.assignment16.ui.theme.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : ComponentActivity() {
    lateinit var database:DatabaseReference
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signup.setOnClickListener{
            var n= binding.name.text.toString()
            var e=binding.email.text.toString()
            var p =binding.password.text.toString()
            var u= binding.uniqueId.text.toString()

            val user= User(n,e,p,u)
            database= FirebaseDatabase.getInstance().getReference("Users")
            database.child(u).setValue(user).addOnSuccessListener{
                Toast.makeText(this,"UserRegistered",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_LONG).show()
            }

        }

    }
}

