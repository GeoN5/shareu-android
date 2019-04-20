package com.example.appjam19.util

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitUtil {

    var retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.211.212:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()!!
}
