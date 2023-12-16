package com.example.apiproject

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apiproject.ui.theme.MyData
import com.example.apiproject.ui.theme.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {
    lateinit var myrecyclerview: RecyclerView
    lateinit var myAdapter:MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       setContentView(R.layout.activity_main)
       val myrecyclerview=findViewById<RecyclerView>(R.id.recyclerdata)

        myrecyclerview.layoutManager= LinearLayoutManager(this)




        val retrofitBuilder=Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitdata=retrofitBuilder.getProductData()

        retrofitdata.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val responsebody=response.body()
                val productList=responsebody?.products
                myAdapter= MyAdapter(applicationContext,productList)
                myrecyclerview.adapter=myAdapter
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {

            }
        })




    }
}

