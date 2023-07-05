package com.example.timer_bottomnav_dependencyinjection.data.remote

 import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel

 import retrofit2.http.GET
 import retrofit2.http.Path
 import java.time.Year


interface ApiCall {
    @GET(ApiDetail.END_POINT)
    suspend fun getHolidayModel(

    ):HolidayModel



}

