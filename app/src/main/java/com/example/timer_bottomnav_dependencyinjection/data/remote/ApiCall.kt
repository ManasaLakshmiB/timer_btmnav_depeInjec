package com.example.timer_bottomnav_dependencyinjection.data.remote

 import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
 import com.example.timer_bottomnav_dependencyinjection.data.model.quotes.QuoteModel
 import com.example.timer_bottomnav_dependencyinjection.data.model.weather.ForecastModel
 import retrofit2.http.GET
 import retrofit2.http.Path
 import java.time.Year


interface ApiCall {
    @GET(ApiDetail.END_POINT)
    suspend fun getHolidayModel(

    ):HolidayModel


//    @GET(ApiDetail.GET_QUOTE)
//    suspend fun getQuote(): QuoteModel
//
//    @GET(ApiDetail.GET_ALL_QUOTES)
//    suspend fun getQuotes(): ArrayList<QuoteModel>

}

