package com.example.moviles_223251_proyecto.register.domain.models

import com.example.moviles_223251_proyecto.login.domain.adapters.TokenResponseAdapter
import com.example.moviles_223251_proyecto.register.domain.adapters.RegisterResponseAdapter

sealed class RegisterState {
    data object Idle : RegisterState()
    data object Loading : RegisterState()
    data class Success(val userResponse : RegisterResponseAdapter) : RegisterState()
    data class Error(val message: String) : RegisterState()
}