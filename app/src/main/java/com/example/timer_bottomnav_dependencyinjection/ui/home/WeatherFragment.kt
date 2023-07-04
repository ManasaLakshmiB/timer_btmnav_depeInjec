package com.example.timer_bottomnav_dependencyinjection.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
import com.example.timer_bottomnav_dependencyinjection.data.remote.ApiDetail
import com.example.timer_bottomnav_dependencyinjection.databinding.FragmentWeatherBinding
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileReader
import kotlin.io.path.Path
import kotlin.io.path.absolutePathString


class WeatherFragment : Fragment() {

    lateinit var binding: FragmentWeatherBinding
    lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWeatherBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
    }

    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {

            try{
                val result = ApiDetail.apiclient.getHolidayModel()







                var adapter = WeatherAdapter(result)

             recyclerView = binding.rvweather
             recyclerView.adapter = adapter
            }catch (e:Exception){
                e.printStackTrace()
            }


//            binding.apply {
////                layoutManager = LinearLayoutManager(context)
////                adapter = WeatherAdapter(result)
//            }
        }
    }
}