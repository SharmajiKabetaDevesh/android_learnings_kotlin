package com.example.cartoonmaker

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONException
import org.json.JSONObject
import java.io.File

@Suppress("DEPRECATION")
class MainActivity2 : AppCompatActivity() {
    companion object{
        const val IMAGE_REQUEST_CODE=100
    }
    private lateinit var  imagedata: ImageView
    private lateinit var buttontakedata: Button
    private lateinit var buttontogenerateimage:Button
    private lateinit var  imageUrl:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        imagedata=findViewById(R.id.imageView)
        buttontakedata=findViewById(R.id.button)
        buttontogenerateimage=findViewById(R.id.buttontogenerate)



        buttontakedata.setOnClickListener{

            picImageFromGallery()

        }

        buttontogenerateimage.setOnClickListener {
            Picasso.get().load(imageUrl).resize(300,450).into(imagedata)
        }

    }
            private fun picImageFromGallery() {
                val intent=Intent(Intent.ACTION_PICK)
                intent.type="image/*"
                startActivityForResult(intent, IMAGE_REQUEST_CODE)
            }




        @Deprecated("Deprecated in Java")
        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
                imagedata.setImageURI(data?.data)

            }

            fun getImagePathFromUri(uri: Uri?): String? {
                val cursor = contentResolver.query(uri!!, null, null, null, null)
                return if (cursor != null) {
                    cursor.moveToFirst()
                    val idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA)
                    val path = cursor.getString(idx)
                    cursor.close()
                    path
                } else {
                    null
                }
            }

        }


    fun fetchdata(){
        val client = OkHttpClient()
// Check if the selectedImageUri is not null
        if (selectedImageUri != null) {
            // Get the image file path from the URI
            val imagePath = getImagePathFromUri(selectedImageUri)

            // Ensure imagePath is not null
            if (imagePath != null) {
                // Create MultipartBody.Builder
                val body = MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart(
                        "image",
                        "image.jpg",
                        RequestBody.create("image/*".toMediaTypeOrNull(), File(imagePath))
                    )
                    .addFormDataPart("type", "3d_cartoon")
                    .build()

                // Rest of your code...
            } else {
                Toast.makeText(this, "Unable to retrieve image path", Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, "No image selected", Toast.LENGTH_LONG).show()
        }

        val mediaType =
            "multipart/form-data; boundary=---011000010111000001101001".toMediaTypeOrNull()
        val body = RequestBody.create(mediaType, "-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"image\"\r\n\r\n\r\n-----011000010111000001101001\r\nContent-Disposition: form-data; name=\"type\"\r\n\r\n<REQUIRED>\r\n-----011000010111000001101001--\r\n\r\n")
        val request = Request.Builder()
            .url("https://cartoon-yourself.p.rapidapi.com/facebody/api/portrait-animation/portrait-animation")
            .post(body)
            .addHeader("content-type", "multipart/form-data; boundary=---011000010111000001101001")
            .addHeader("X-RapidAPI-Key", "42818d9063msh3ba205644d8831dp1d2095jsn49e63c9464be")
            .addHeader("X-RapidAPI-Host", "cartoon-yourself.p.rapidapi.com")
            .build()

        val response = client.newCall(request).execute()
    }


}
