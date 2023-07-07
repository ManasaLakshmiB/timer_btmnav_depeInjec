package com.example.timer_bottomnav_dependencyinjection.ui.holiday

import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.timer_bottomnav_dependencyinjection.R
import com.example.timer_bottomnav_dependencyinjection.databinding.ActivityHolidayBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ActivityHoliday : AppCompatActivity() {

    private lateinit var binding: ActivityHolidayBinding
    lateinit var navController :NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHolidayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

         navController = findNavController(R.id.nav_host_fragment_activity_btm_nav_bar)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_dashboard,
               // R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener{ _,destination,_->
            when(destination.id){
                R.id.navigation_home->{
                    navView.visibility = View.VISIBLE
                }
                R.id.navigation_dashboard->{
                    navView.visibility = View.VISIBLE
                }
                else->{
                    navView.visibility = View.GONE
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}