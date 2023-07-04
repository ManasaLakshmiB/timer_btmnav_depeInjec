package com.example.timer_bottomnav_dependencyinjection.data.model.quotes


import com.google.gson.annotations.SerializedName

data class QuoteModel(
    @SerializedName("author")
    val author: String? = "",
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("quote")
    val quote: String? = "",
    @SerializedName("series")
    val series: String? = ""
)