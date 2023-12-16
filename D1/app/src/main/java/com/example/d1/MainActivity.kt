package com.example.d1

import android.content.Intent
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
import com.example.d1.databinding.ActivityMainBinding
import com.example.d1.ui.theme.D1Theme
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : ComponentActivity() {
    private lateinit var database:DatabaseReference
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.signup.setOnClickListener{
            val e=binding.email.text.toString()
            if(e.isNotEmpty()){
                readData(e)
            }else{
                Toast.makeText(this,"Network Failure",Toast.LENGTH_LONG).show()
            }


        }
    }

    private fun readData(email:String){
        database=FirebaseDatabase.getInstance().getReference("Users")

        database.child(email).get().addOnSuccessListener {
            if(it.exists()){
                val email=it.child("email").value.toString()
                val name=it.child("name").value.toString()
                val userId=it.child("uniqueId").value.toString()

                val intent = Intent(this,MainActivity2::class.java)
                intent.putExtra("email",email)
                intent.putExtra("name",name)
                intent.putExtra("userId",userId)
                startActivity(intent)
            }else{
                Toast.makeText(this,"SignUp Kar lijiye pehle",Toast.LENGTH_LONG).show()
            }
        }.addOnFailureListener{
            Toast.makeText(this,"SignUp Kar lijiye pehle",Toast.LENGTH_LONG).show()
        }
    }
}
