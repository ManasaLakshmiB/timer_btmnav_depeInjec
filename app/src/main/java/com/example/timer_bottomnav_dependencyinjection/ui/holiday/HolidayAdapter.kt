package com.example.timer_bottomnav_dependencyinjection.ui.holiday

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.timer_bottomnav_dependencyinjection.R
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayItemModel
import com.example.timer_bottomnav_dependencyinjection.data.model.Holidays.HolidayModel
import com.example.timer_bottomnav_dependencyinjection.databinding.ItemHolidayBinding


class HolidayAdapter(val holidayModel: HolidayModel):RecyclerView.Adapter<HolidayAdapter.ViewHolder>() {

    class ViewHolder( val view:View) :RecyclerView.ViewHolder(view) {


     //val itemDetail: TextView = itemView.findViewById(R.id.tvholiday)

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition


               // Toast.makeText(itemView.context, "you clicked on", Toast.LENGTH_SHORT).show()
            }
        }

        val binding = ItemHolidayBinding.bind(view)
        fun updateUI(quote: HolidayItemModel) {
            binding.apply{
                tvholiday.text  = quote.localName

//                Glide.with(view)
                //tvweather.linksClickable
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
  return ViewHolder(
      LayoutInflater.from(parent.context).inflate(R.layout.item_holiday,
          parent,false)
  )
    }
    override fun getItemCount() = holidayModel.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
 holder.updateUI(holidayModel[position])
      //  holder.itemDetail


   }





}