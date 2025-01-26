package com.example.moviles_223251_proyecto.register.ui.viewmodels

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ColorFilter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviles_223251_proyecto.core.domain.models.TextFieldConfig
import com.example.moviles_223251_proyecto.register.data.services.RegisterService
import com.example.moviles_223251_proyecto.register.domain.dtos.RegisterUserDto
import com.example.moviles_223251_proyecto.register.domain.models.RegisterState
import kotlinx.coroutines.launch

class RegisterViewModel( app : Application) : AndroidViewModel(app) {
    private val email = mutableStateOf("")
    private val password = mutableStateOf("")
    private val username = mutableStateOf("")
    private val registerService = RegisterService()
    val registerState = mutableStateOf<RegisterState>(RegisterState.Idle)


    fun getTextFields () : List<TextFieldConfig> {
        return listOf(
            TextFieldConfig(
                value = username.value,
                onValueChange = { username.value = it },
                label = "Username",
                leadingIcon = {
                    Image(
                        imageVector = Icons.Filled.AccountCircle,
                        contentDescription = "User icon",
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )
                }
            ),
            TextFieldConfig(
                value = email.value,
                onValueChange = { email.value = it },
                label = "Email",
                leadingIcon = {
                    Image(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email icon",
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )
                }
            ),
            TextFieldConfig(
                value = password.value,
                onValueChange = { password.value = it },
                label = "Password",
                leadingIcon = {
                    Image(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Lock icon",
                        colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
                    )
                }
            ),
        )
    }

    private fun getRegisterUserDto() : RegisterUserDto {
        return RegisterUserDto(username = username.value, email = email.value, password = password.value)
    }

    fun registerUser() {
        val registerUserDto = getRegisterUserDto()

        if (registerUserDto.isValid()) {
           viewModelScope.launch {
                registerState.value = RegisterState.Loading
                val result = registerService.register(registerUserDto)

                result.fold(
                    onSuccess = { registerResponse ->
                        registerState.value = RegisterState.Success(registerResponse)
                    },
                    onFailure = { exception ->
                        registerState.value = RegisterState.Error(exception.message ?: "Error desconocido")
                    }
                )
                username.value = ""
                email.value = ""
                password.value = ""
           }
        }else{
            registerState.value = RegisterState.Error("Credenciales no son válidas")
        }
    }

    fun restartRegisterState() {
        registerState.value = RegisterState.Idle
    }
}