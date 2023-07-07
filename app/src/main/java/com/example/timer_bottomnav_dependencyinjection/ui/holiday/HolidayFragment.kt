package com.example.timer_bottomnav_dependencyinjection.ui.holiday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.timer_bottomnav_dependencyinjection.data.remote.HolidayCall
import com.example.timer_bottomnav_dependencyinjection.data.repository.Repository
import com.example.timer_bottomnav_dependencyinjection.databinding.FragmentHolidayBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HolidayFragment : Fragment() {

    lateinit var binding: FragmentHolidayBinding
    lateinit var recyclerView: RecyclerView

//    @Inject
//    lateinit var repository: Repository

    val viewmodel by viewModels<HolidayViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//to display the data without delay we used viewmodel inside the on create method
        viewmodel.getHolidayData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//val viewmodel :HolidayViewModel by viewModel<>()
        // val viewmodel :HolidayViewModel by viewModels<HolidayViewModel>()
        // Inflate the layout for this fragment
        binding = FragmentHolidayBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?)  {
        super.onViewCreated(view, savedInstanceState)

//        loadData()
        recyclerView = binding.rvholiday

        viewmodel.HolidayliveData.observe(viewLifecycleOwner) {
            var adapter = HolidayAdapter(it)
            recyclerView.adapter = adapter
        }

    }


//    private fun loadData() {
//        CoroutineScope(Dispatchers.Main).launch {
//
//            try {
//                //  val result = ApiDetail.apiclient.getHolidayModel()
//                val result = repository.getHolidayModel()
//
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//
//
////            binding.apply {
//////                layoutManager = LinearLayoutManager(context)
//////                adapter = WeatherAdapter(result)
////            }
//        }
//    }
}