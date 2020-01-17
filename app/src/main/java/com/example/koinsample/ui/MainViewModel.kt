package com.example.koinsample.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.koinsample.utils.PreferenceHelper
import org.koin.dsl.module

val mainViewModelModule = module {
    factory { MainViewModel(get()) }
}

class MainViewModel(preferenceHelper: PreferenceHelper) : ViewModel(){
     val fragmentContent = MutableLiveData<String>()

    init {
        fragmentContent.value = preferenceHelper.getFragmentContent()
    }
}