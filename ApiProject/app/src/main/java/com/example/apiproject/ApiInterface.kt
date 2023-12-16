package com.example.apiproject

import com.example.apiproject.ui.theme.MyData
import com.example.apiproject.ui.theme.Product
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("products")
    fun getProductData():Call<MyData>

}