package com.example.contactsaver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactsaver.databinding.ActivityMain2Binding
import com.example.contactsaver.ui.theme.User
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivityMain2Binding
    lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signup.setOnClickListener {
            // Retrieve data from EditText fields
            val name = binding.name.text.toString()
            val email = binding.email.text.toString()
            val number = binding.number.text.toString()

            // Check if any of the fields is empty
            if (name.isEmpty() || email.isEmpty() || number.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Create a User object
            val user = User(name, email, number)

            // Initialize Firebase database reference
            database = FirebaseDatabase.getInstance().getReference("User")

            // Set user data in the database
            database.child(number).setValue(user).addOnSuccessListener {
                Toast.makeText(this, "Sign Up Successful", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity3::class.java)
                startActivity(intent)
            }.addOnFailureListener {
                Toast.makeText(this, "Oops! Something went wrong. Try Again", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
