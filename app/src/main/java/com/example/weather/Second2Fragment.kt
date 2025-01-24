package com.example.weather

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.weather.databinding.FragmentSecond2Binding
import com.example.weather.viewModel.SignUpViewModel
import com.example.weather.viewModel.WeatherViewModel

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class Second2Fragment : Fragment() {

    private var _binding: FragmentSecond2Binding? = null
    private val viewModel by viewModels<SignUpViewModel>()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecond2Binding.inflate(inflater, container, false)
        viewModel.createUser("jpgpineda98@gmail.com", "12345")
        return binding.root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}