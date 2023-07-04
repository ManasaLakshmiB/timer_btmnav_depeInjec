package com.example.timer_bottomnav_dependencyinjection.data.model.weather


import com.google.gson.annotations.SerializedName

data class WeatherModel(
    @SerializedName("description")
    val description: String? = "",
    @SerializedName("forecast")
    val forecast: List<ForecastModel?>? = listOf(),
    @SerializedName("temperature")
    val temperature: String? = "",
    @SerializedName("wind")
    val wind: String? = ""
)