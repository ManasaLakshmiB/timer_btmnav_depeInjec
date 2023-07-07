package com.example.timer_bottomnav_dependencyinjection.data.repository

import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
import com.example.timer_bottomnav_dependencyinjection.data.remote.HolidayCall
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
   val  holidayCall: HolidayCall
):Repository {

    override suspend fun getHolidayModel() = holidayCall.getHolidayModel()
//    override suspend fun getHolidayModel(): HolidayModel {
// return holidayCall.getHolidayModel()
    }

