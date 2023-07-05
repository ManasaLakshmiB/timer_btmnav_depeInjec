package com.example.timer_bottomnav_dependencyinjection.ui.holiday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.timer_bottomnav_dependencyinjection.R
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayItemModel
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
import com.example.timer_bottomnav_dependencyinjection.data.remote.ApiDetail
import com.example.timer_bottomnav_dependencyinjection.databinding.FragmentHolidayBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class HolidayFragment : Fragment() {

    lateinit var binding: FragmentHolidayBinding
    lateinit var recyclerView:RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHolidayBinding.inflate(inflater, container, false)


        return binding.root
        loadData()
    }

//        binding.rvholiday.setOnClickListener(
//            findNavController().navigate(
//                R.id.action_navigation_home_to_holidaydetailFragment ,
//
//
//
//            )
//        )



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
    }





    private fun loadData() {
        CoroutineScope(Dispatchers.Main).launch {

            try{
                val result = ApiDetail.apiclient.getHolidayModel()
                var adapter = HolidayAdapter(result)

             recyclerView = binding.rvholiday
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