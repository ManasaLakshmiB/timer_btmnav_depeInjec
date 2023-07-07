package com.example.timer_bottomnav_dependencyinjection.data.repository

import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel

interface Repository {

    suspend fun getHolidayModel(): HolidayModel
}