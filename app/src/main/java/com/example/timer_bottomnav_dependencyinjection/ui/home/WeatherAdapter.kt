package com.example.timer_bottomnav_dependencyinjection.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.timer_bottomnav_dependencyinjection.R
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayItemModel
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
import com.example.timer_bottomnav_dependencyinjection.data.model.weather.ForecastModel
import com.example.timer_bottomnav_dependencyinjection.databinding.ItemWeatherBinding

class WeatherAdapter(val holidayModel: HolidayModel):RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder( val view:View) :RecyclerView.ViewHolder(view) {

        val binding = ItemWeatherBinding.bind(view)
        fun updateUI(quote: HolidayItemModel) {
            binding.apply{
                tvweather.text  = quote.localName
//                Glide.with(view)

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
  return ViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_weather,
          parent,false)
  )
    }
    override fun getItemCount() = holidayModel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
 holder.updateUI(holidayModel[position])
   }





}