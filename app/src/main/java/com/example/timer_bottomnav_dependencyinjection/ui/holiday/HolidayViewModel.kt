package com.example.timer_bottomnav_dependencyinjection.ui.holiday

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
import com.example.timer_bottomnav_dependencyinjection.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HolidayViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    //    private val _text = MutableLiveData<String>().apply {
//        value = "This is Holiday Fragment"
//    }
//    val text: LiveData<String> = _text

    //this field actually holds the data passed to it via MutableLiveData::postValue()
    // mutable is used because we can chnage the data
    val HolidayliveData: MutableLiveData<HolidayModel> by lazy {
        MutableLiveData<HolidayModel>()
    }

    fun getHolidayData() {
        CoroutineScope(Dispatchers.Main).launch {
            val result = repository.getHolidayModel()
            HolidayliveData.postValue(result)//smart and only updates the value when resource is available
//            HolidayliveData.value = result//urgently replace the current value (high priority)
        }

    }
}


