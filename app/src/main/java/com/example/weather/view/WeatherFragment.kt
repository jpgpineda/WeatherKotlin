package com.example.weather.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.weather.R
import com.example.weather.utils.FragmentCommunicator
import com.example.weather.databinding.FragmentWeatherBinding
import com.example.weather.model.WeatherData
import com.example.weather.viewModel.WeatherViewModel

class WeatherFragment : Fragment() {

    private var _binding: FragmentWeatherBinding? = null
    private val binding get() = _binding!!
    private lateinit var communicator: FragmentCommunicator
    private val viewModel by viewModels<WeatherViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWeatherBinding.inflate(inflater, container, false)
        communicator = requireActivity() as FragmentCommunicator
        setupObservers()
        setupView()
        return binding.root
    }

    private fun setupObservers() {
        viewModel.weatherInfo.observe(viewLifecycleOwner) { weatherInfo ->
            updateUI(weatherInfo)
        }
        viewModel.loaderState.observe(viewLifecycleOwner) { showLoader ->
            communicator.manageLoader(showLoader)
        }
    }

    private fun setupView() {
        viewModel.fetchWeatherInfo("19.3241552,-99.1872086")
        binding.menuButton.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    private fun updateUI(weatherInfo: WeatherData) {
        binding.cityTextView.text = weatherInfo.location.region
        binding.localTimeTextView.text = weatherInfo.location.localTime
        binding.temperatureTextView.text = weatherInfo.current.temp.toString() + " °C"
        binding.humidityTextView.text = weatherInfo.current.humidity.toString() + " %"
        binding.windSpeedTextView.text = weatherInfo.current.windSpeed.toString() + " kmp"
        binding.feelsLikeTextView.text = weatherInfo.current.feelsLike.toString() + " °C"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}