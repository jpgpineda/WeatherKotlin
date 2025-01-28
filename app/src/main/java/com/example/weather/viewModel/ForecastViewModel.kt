package com.example.weather.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.core.WeatherRepository
import com.example.weather.model.WeatherData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ForecastViewModel: ViewModel() {
    private val weatherRepository = WeatherRepository()
    private val _forecastInfo = MutableLiveData<WeatherData>()
    val forecastInfo: LiveData<WeatherData>
        get() = _forecastInfo
    private val _loaderState = MutableLiveData<Boolean>()
    val loaderState: LiveData<Boolean>
        get() = _loaderState

    fun fetchForecastData(coordinates: String) {
        _loaderState.value = true
        viewModelScope.launch {
            val response = weatherRepository.fetchForecastInfo(coordinates)
            _loaderState.value = false
            response?.let {
                _forecastInfo.value = it
            } ?: run {
                Log.e("ERROR", "NO SE PUDO OBTENER LA INFORMACION")
            }
        }
    }
}