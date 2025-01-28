package com.example.weather.core

import android.util.Log
import com.example.weather.model.WeatherData

class WeatherRepository {
    private val retrofit = RetrofitInstance.getRetrofit().create(WeatherAPI::class.java)

    suspend fun fetchWeatherInfo(coordinates: String): WeatherData? {
        val response = retrofit.getWeatherInfo("73c648b0d07f4fbc9c3150707252101", coordinates)
        Log.i("RESPONSE", response.body().toString())

        return response.body()
    }

    suspend fun fetchForecastInfo(coordinates: String): WeatherData? {
        val response = retrofit.getForecastInfo("73c648b0d07f4fbc9c3150707252101",
            coordinates,
            days = 7)
        Log.i("RESPONSE", response.body().toString())

        return response.body()
    }
}