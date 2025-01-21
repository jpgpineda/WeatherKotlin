package com.example.weather.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.AppBarConfiguration
import com.example.weather.utils.FragmentCommunicator
import com.example.weather.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity(), FragmentCommunicator {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMain2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    override fun manageLoader(isVisible: Boolean) {
        if (isVisible) {
            binding.loaderView.visibility = View.VISIBLE
        } else {
            binding.loaderView.visibility = View.GONE
        }
        // binding.loaderView.visibility = if (isVisible) View.VISIBLE else View.GONE
    }
}