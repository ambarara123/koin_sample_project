package com.example.koinsample.network

import okhttp3.Interceptor
import okhttp3.Response

class NetworkInterceptor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        var req = chain.request()
        val url = req.url()
            .newBuilder()
            .addQueryParameter("APPID", "your_api_key")
            .build()

        req = req.newBuilder().url(url).build()

        return chain.proceed(req)
    }

}