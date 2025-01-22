package com.example.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherData(
    val location: Location,
    val current: Current
)

data class Current(
    @SerializedName("temp_c") val temp: Int,
    val condition: Condition,
    @SerializedName("is_day") val isDay: Int,
    val humidity: Int,
    @SerializedName("last_updated") val lastUpdated: String,
    val cloud: Int,
    @SerializedName("wind_mph") val windSpeed: Int,
    @SerializedName("feelslike_c") val feelsLike: Int
)

data class Location(
    val name: String,
    val region: String,
    val country: String,
    @SerializedName("localtime") val localTime: String
)

data class Condition(
    val text: String,
    val icon: String
)
