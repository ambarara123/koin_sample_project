package com.example.koinsample.data

import com.example.koinsample.network.ApiService
import org.koin.dsl.module

val repositoryModule = module {
    factory { MainRepository(get()) }
}

class MainRepository (private val apiService: ApiService){
    suspend fun getData() = apiService.getNetworkData()
}