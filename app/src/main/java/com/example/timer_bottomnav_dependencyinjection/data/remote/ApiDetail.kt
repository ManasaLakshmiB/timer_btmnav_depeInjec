package com.example.timer_bottomnav_dependencyinjection.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiDetail {

    const val BASE_URL="https://date.nager.at/api/"
    const val END_POINT="v3/PublicHolidays/2023/us"

//    const val BASE_URL="https://api.seriesquotes.10cyrilc.me/"
//    const val GET_QUOTE="quote/"
//    const val GET_ALL_QUOTES="all"

    val okhttpClient =OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        })
        .build()

    val retrofitinstance   = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okhttpClient)
        .build()


    val apiclient = retrofitinstance.create(HolidayCall::class.java)
}
