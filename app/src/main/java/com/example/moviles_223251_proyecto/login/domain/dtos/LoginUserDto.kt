package com.example.moviles_223251_proyecto.login.domain.dtos

data class LoginUserDto(
    val email : String = "",
    val password : String = ""
) {
    fun isValid() : Boolean {
        return email.isNotEmpty() && password.isNotEmpty()
    }
}