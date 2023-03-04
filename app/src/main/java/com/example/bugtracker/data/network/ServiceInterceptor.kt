package com.example.bugtracker.data.network

import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("X-AUTH-TOKEN","38fa0880d113c79d8e0196481d4f4562576b5348de1ab9619696d3449de5")
            .addHeader("Content-Type", "application/json")
            .addHeader("Application", "application/json")
            .build()
        return chain.proceed(request)
    }
}
