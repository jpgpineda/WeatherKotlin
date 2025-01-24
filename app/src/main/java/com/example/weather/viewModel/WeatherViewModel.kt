package com.example.weather.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.core.WeatherRepository
import com.example.weather.model.WeatherData
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    private val weatherRepository = WeatherRepository()
    private val _weatherInfo = MutableLiveData<WeatherData>()
    val weatherInfo: LiveData<WeatherData>
        get() = _weatherInfo
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState

    fun fetchWeatherInfo(coodinates: String) {
        _loaderState.value = true
        viewModelScope.launch {
            val response = weatherRepository.fetchWeatherInfo(coodinates)
            _loaderState.value = false
            response?.let { weather ->
                _weatherInfo.value = weather
            } ?: run {
                Log.e("Error", "No se pudo crear la informacion")
            }
        }
    }
}