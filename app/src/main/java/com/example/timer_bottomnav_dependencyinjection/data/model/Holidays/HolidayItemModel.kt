package com.example.timer_bottomnav_dependencyinjection.data.model.Holidays


import com.google.gson.annotations.SerializedName

data class HolidayItemModel(
    @SerializedName("counties")
    val counties: List<String?>? = listOf(),
    @SerializedName("countryCode")
    val countryCode: String? = "",
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("fixed")
    val fixed: Boolean? = false,
    @SerializedName("global")
    val global: Boolean? = false,
    @SerializedName("launchYear")
    val launchYear: Int? = 0,
    @SerializedName("localName")
    val localName: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("type")
    val type: String? = ""
)