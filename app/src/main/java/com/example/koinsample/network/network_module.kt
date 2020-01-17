package com.example.koinsample.network

import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    factory { NetworkInterceptor() }
    factory { provideOkHttpClient(get()) }
    factory { provideNetworkApi(get()) }
    single { provideRetrofit(get()) }
}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit{
    return Retrofit.Builder().baseUrl("")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideOkHttpClient(interceptor: NetworkInterceptor): OkHttpClient{
    return OkHttpClient().newBuilder().addInterceptor(interceptor).build()
}

fun provideNetworkApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)