package com.example.moviles_223251_proyecto.login.domain.adapters

data class UserAdapter(val id : Int, val email : String, val username : String) {
    fun isValid() : Boolean {
        return id > 0 && email.isNotEmpty() && username.isNotEmpty()
    }
}