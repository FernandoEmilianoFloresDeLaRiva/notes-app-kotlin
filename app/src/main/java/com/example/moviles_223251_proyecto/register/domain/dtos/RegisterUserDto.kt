package com.example.moviles_223251_proyecto.register.domain.dtos

data class RegisterUserDto(
    val email : String,
    val password : String,
    val username : String
) {
    fun isValid() : Boolean {
        return email.isNotEmpty() && password.isNotEmpty() && username.isNotEmpty()
    }
}