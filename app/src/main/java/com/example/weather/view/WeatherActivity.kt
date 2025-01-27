package com.example.weather.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.weather.R
import com.example.weather.databinding.ActivityOnboardingBinding
import com.example.weather.databinding.ActivityWeatherBinding
import com.example.weather.utils.FragmentCommunicator

class WeatherActivity : AppCompatActivity(), FragmentCommunicator {
    private lateinit var binding: ActivityWeatherBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityWeatherBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun manageLoader(isVisible: Boolean) {
        if (isVisible) {
            binding.loaderView.visibility = View.VISIBLE
        } else {
            binding.loaderView.visibility = View.GONE
        }
    }
}