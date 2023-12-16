package com.example.recyclerviewpractise.ui.theme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.recyclerviewpractise.R

class NewsDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_detail)

        val dataheading=intent.getStringExtra("heading")
        val datacontent=intent.getStringExtra("newscontent")
        val dataimages=intent.getIntExtra("images",R.drawable.pic12)

        val heading=findViewById<TextView>(R.id.newsheading)
        val detail=findViewById<TextView>(R.id.newsdetails)
        val image=findViewById<ImageView>(R.id.newsimage)

        heading.text=dataheading
        detail.text=datacontent
        image.setImageResource(dataimages)



    }
}