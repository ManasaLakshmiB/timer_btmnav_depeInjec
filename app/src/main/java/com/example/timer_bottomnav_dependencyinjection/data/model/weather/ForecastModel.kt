package com.example.timer_bottomnav_dependencyinjection.data.model.weather


import com.google.gson.annotations.SerializedName

data class ForecastModel(
    @SerializedName("day")
    val day: String? = "",
    @SerializedName("temperature")
    val temperature: String? = "",
    @SerializedName("wind")
    val wind: String? = ""
)