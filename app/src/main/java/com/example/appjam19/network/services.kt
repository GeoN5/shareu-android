package com.example.appjam19.network

import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService{

    @GET("api/articles")//모든 재능기부 목록
    fun getArticles() : Call<Beans>

    @GET("api/articles/search")
    @FormUrlEncoded
    fun getFilter(@Query("address")lat:Double): Call<Beans>//클래스 지도 검색

}

