package com.example.artgallery.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.artgallery.R
import com.example.artgallery.databinding.ActivityMainBinding
import com.example.artgallery.presentation.onboarding.FirstOnBoardingFragment
import com.example.artgallery.utilits.APP_ACTIVITY
import com.example.artgallery.utilits.replaceFragmentMain
import com.example.artgallery.utilits.setStatusBarGradiantMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        setContentView(binding.root)
        setStatusBarGradiantMain(this)

        replaceFragmentMain(FirstOnBoardingFragment())

       /* binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.home -> replaceFragmentMain(HomeFragment())
                R.id.save -> replaceFragmentMain(SaveFragment())

                else -> hideBottomNavigationView()
            }
            true
        }*/
    }

    fun hideBottomNavigationView() {
        binding.bottomNavigationView.visibility = View.GONE
    }

    fun showBottomNavigationView() {
        binding.bottomNavigationView.visibility = View.VISIBLE
    }
}