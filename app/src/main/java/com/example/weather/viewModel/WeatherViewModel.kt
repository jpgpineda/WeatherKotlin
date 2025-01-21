package com.example.weather.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WeatherViewModel: ViewModel() {
    private val _weatherInfo = MutableLiveData<String>()
    val weatherInfo: LiveData<String>
        get() = _weatherInfo
}