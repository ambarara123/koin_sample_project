package com.example.koinsample.utils

import android.content.Context
import android.content.SharedPreferences
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val prefModule = module {
    single { PreferenceHelper(androidContext()) }
}

class PreferenceHelper (context: Context){
    private val preferences: SharedPreferences = context.getSharedPreferences("preference",Context.MODE_PRIVATE)
    private val showFragmentKey = "showFragment"

    fun storeShouldShowFragment(shouldShow: Boolean){
        preferences.edit().putBoolean(showFragmentKey,shouldShow).apply()
    }

    fun getFragmentContent(): String{
        return "fake content"
    }

    fun getShouldShowFragment(): Boolean{
        return preferences.getBoolean(showFragmentKey,false)
    }
}