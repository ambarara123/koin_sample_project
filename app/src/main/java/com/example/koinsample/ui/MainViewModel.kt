package com.example.koinsample.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.koinsample.data.MainRepository
import kotlinx.coroutines.launch
import org.koin.dsl.module

val mainViewModelModule = module {
    factory { MainViewModel(get()) }
}

class MainViewModel(private val mainRepository: MainRepository) : ViewModel() {

    private val _networkLiveData = MutableLiveData<String>()

    val networkLiveData: LiveData<String>
        get() = _networkLiveData

    fun getData() {
        viewModelScope.launch {
            _networkLiveData.value = mainRepository.getData().body()
        }
    }
}