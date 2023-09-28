package com.example.artgallery.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.artgallery.databinding.ActivityMainBinding
import com.example.artgallery.utilits.APP_ACTIVITY
import com.example.artgallery.utilits.setStatusBarGradiantMain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        APP_ACTIVITY = this
        setContentView(binding.root)
        setStatusBarGradiantMain(this)
    }
}