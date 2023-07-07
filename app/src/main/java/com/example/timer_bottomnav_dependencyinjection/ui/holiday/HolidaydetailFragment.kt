package com.example.timer_bottomnav_dependencyinjection.ui.holiday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.timer_bottomnav_dependencyinjection.R
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayItemModel
import com.example.timer_bottomnav_dependencyinjection.databinding.FragmentHolidayBinding
import com.example.timer_bottomnav_dependencyinjection.databinding.FragmentHolidaydetailBinding
import com.google.gson.Gson

class HolidaydetailFragment : Fragment() {

lateinit var binding: FragmentHolidaydetailBinding

lateinit var quote: HolidayItemModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        quote = Gson().fromJson(arguments?.getString("item"), HolidayItemModel::class.java)

//        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHolidaydetailBinding.inflate(inflater, container ,false)
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_holidaydetail, container, false)

        binding.apply {
            tvhd.text = getString(R.string.country_code,quote.countryCode)

            hdate.text = getString(R.string.Date, quote.date)

            tvglobal.text = if (quote.global == true) getString(R.string.global,"yes") else
              getString ( R.string.global,"no")
        }


        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Toast.makeText(requireContext(), , Toast.LENGTH_SHORT).show()
        println(Gson().toJson(quote))
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            android.R.id.home->{
//                findNavController().navigateUp()
//            }
//        }
//
//        return super.onOptionsItemSelected(item)
//    }
}