package com.example.listviewcustomadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)
        val name=intent.getStringExtra("name")
        val phone=intent.getStringExtra("phone")
        val imageId=intent.getIntExtra("image",R.drawable.pic11)

        val nametxt=findViewById<TextView>(R.id.textname)
        val phonetxt=findViewById<TextView>(R.id.textphone)
        val profileimage=findViewById<CircleImageView>(R.id.profile_image)

        nametxt.text = name
        phonetxt.text = phone
        profileimage.setImageResource(imageId)

    }
}