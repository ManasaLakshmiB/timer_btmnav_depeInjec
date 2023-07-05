package com.example.timer_bottomnav_dependencyinjection.ui.holiday

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HolidayViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Holiday Fragment"
    }
    val text: LiveData<String> = _text
}