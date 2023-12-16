package com.example.cartoonimagemaker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    lateinit var  imagedata:ImageView
    lateinit var buttontakedata:Button
    companion object{
        val IMAGE_REQUEST_CODE=100
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        imagedata=findViewById<ImageView>(R.id.imageView)
        buttontakedata=findViewById<Button>(R.id.button)


        buttontakedata.setOnClickListener{

       picImageFromGallery()

        }

    }

    private fun picImageFromGallery() {
        val intent= Intent(Intent.ACTION_PICK)
        intent.type="image/*"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode== IMAGE_REQUEST_CODE&&resultCode== RESULT_OK){
            imagedata.setImageURI(data?.data)
        }
    }
}