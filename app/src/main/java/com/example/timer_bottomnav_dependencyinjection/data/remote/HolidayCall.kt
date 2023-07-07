package com.example.timer_bottomnav_dependencyinjection.data.remote

 import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayItemModel
 import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel

 import retrofit2.http.GET


interface HolidayCall {
    @GET(ApiDetail.END_POINT)
    suspend fun getHolidayModel():HolidayModel
//    suspend fun getHolidayModel():ArrayList<HolidayItemModel>



}

