package com.example.bugtracker.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val okHttpClient = OkHttpClient.Builder().apply {
        addInterceptor(ServiceInterceptor())
    }.build()

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl("https://lk.ellco.ru:8000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api: BugApi by lazy {
        retrofit.create(BugApi::class.java)
    }
}
