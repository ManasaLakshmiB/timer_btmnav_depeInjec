package com.example.timer_bottomnav_dependencyinjection

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.timer_bottomnav_dependencyinjection.databinding.FragmentCountdownBinding
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class CountdownFragment : Fragment() {

    private var _binding: FragmentCountdownBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCountdownBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val interval:Long=5
        val countNumber:Long = 5000
        val countDown = CountDown(countNumber,interval)
        countDown.start()

//        binding.apply {
//
//
//
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    internal inner class CountDown(milliseconds:Long, countDownInterval:Long):CountDownTimer(milliseconds,countDownInterval){


        private val timeFormat = SimpleDateFormat("00:mm:ss", Locale.US)

        override fun onTick(millisUntilFinished: Long) {

            val formatedTime = timeFormat.format(millisUntilFinished)
            binding.textviewFirst.text =    formatedTime    }



        override fun onFinish() {

            startActivity(
                Intent(this@CountdownFragment.requireContext(),ActivityHoliday::class.java)

            )
        }
    }
}