package com.example.timer_bottomnav_dependencyinjection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.timer_bottomnav_dependencyinjection.databinding.FragmentHolidayBinding
import com.example.timer_bottomnav_dependencyinjection.databinding.FragmentHolidaydetailBinding

class HolidaydetailFragment : Fragment() {

lateinit var binding: FragmentHolidaydetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHolidaydetailBinding.inflate(inflater, container ,false)
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_holidaydetail, container, false)

        return  binding.root
    }


}