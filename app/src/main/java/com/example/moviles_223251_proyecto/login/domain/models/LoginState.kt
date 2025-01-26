package com.example.moviles_223251_proyecto.login.domain.models

import com.example.moviles_223251_proyecto.login.domain.adapters.TokenResponseAdapter

sealed class LoginState {
    data object Idle : LoginState()
    data object Loading : LoginState()
    data class Success(val token: TokenResponseAdapter) : LoginState()
    data class Error(val message: String) : LoginState()
}