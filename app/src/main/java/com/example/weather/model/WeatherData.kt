package com.example.weather.model

import com.google.gson.annotations.SerializedName

data class WeatherData(
    val location: Location,
    val current: Current,
    val forecast: Forecast?
)

data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val day: Day
)

data class Day(
    @SerializedName("maxtemp_c") val maxTemp: Double,
    @SerializedName("mintemp_c") val minTemp: Double,
    val condition: Condition
)

data class Current(
    @SerializedName("temp_c") val temp: Double,
    val condition: Condition,
    @SerializedName("is_day") val isDay: Int,
    val humidity: Int,
    @SerializedName("last_updated") val lastUpdated: String,
    val cloud: Int,
    @SerializedName("wind_mph") val windSpeed: Double,
    @SerializedName("feelslike_c") val feelsLike: Double
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
