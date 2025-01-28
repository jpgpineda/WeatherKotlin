package com.example.weather.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.databinding.FragmentLocationBinding
import com.example.weather.model.ForecastDay
import com.example.weather.utils.FragmentCommunicator
import com.example.weather.view.adapters.ForecastAdapter
import com.example.weather.viewModel.ForecastViewModel
import com.example.weather.viewModel.WeatherViewModel

class ForecastFragment : Fragment() {

    private var _binding: FragmentLocationBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ForecastViewModel>()
    private lateinit var communicator: FragmentCommunicator
    private lateinit var forecastAdapter: ForecastAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        communicator = requireActivity() as FragmentCommunicator
        setupView()
        setupObservers()
        viewModel.fetchForecastData("19.3241502,-99.3288293")
        return binding.root

    }

    private fun setupView() {
        forecastAdapter = ForecastAdapter(
            mutableListOf()
        )
        binding.forecastRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = forecastAdapter
        }
    }

    private fun setupObservers() {
        viewModel.forecastInfo.observe(viewLifecycleOwner) { forecast ->
            updateUI(forecast.forecast?.forecastday ?: emptyList())
        }
        viewModel.loaderState.observe(viewLifecycleOwner) { showLoader ->
            communicator.manageLoader(showLoader)
        }
    }

    private fun updateUI(forecast: List<ForecastDay>) {
        forecastAdapter.add(forecast)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}