package com.example.koinsample.network

import retrofit2.Response
import retrofit2.http.GET

interface ApiService{
    @GET("")
    suspend fun getNetworkData(): Response<String>
}