package com.example.contactsaver

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.contactsaver.databinding.ActivityMain3Binding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity3 : AppCompatActivity() {
    private lateinit var binding: ActivityMain3Binding
    private lateinit var database: DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)


        database= FirebaseDatabase.getInstance().getReference("User")
        binding.signin.setOnClickListener {
            var number=binding.number.text.toString()
            database.child(number).get().addOnSuccessListener {
                if(it.exists()){
                    val name=it.child("name").value
                    val email=it.child("email").value
                    if(name!=null &&email !=null){
                        startActivity(Intent(this,Contact::class.java))
                    }
                }else{
                    Toast.makeText(this,"Sign Up Please",Toast.LENGTH_LONG).show()
                }

            }
        }
    }
}