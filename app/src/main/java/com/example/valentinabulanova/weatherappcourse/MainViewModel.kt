package com.example.valentinabulanova.weatherappcourse

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.valentinabulanova.weatherappcourse.Adapters.WeatherModel

class MainViewModel: ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<WeatherModel>>()
}