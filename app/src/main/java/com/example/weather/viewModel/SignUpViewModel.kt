package com.example.weather.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.core.SessionRepository
import kotlinx.coroutines.launch

class SignUpViewModel: ViewModel() {
    private val repository = SessionRepository()

    fun createUser(email: String, password: String) {
        viewModelScope.launch {
            val result = repository.registerUser(email, password)
            result?.let { user ->
                Log.i("Session", "SE ha creado el usuario")
            } ?: run {
                Log.e("Error", "No se pudo crear el usuario")
            }
        }
    }
}