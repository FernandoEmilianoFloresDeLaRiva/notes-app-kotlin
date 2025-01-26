package com.example.moviles_223251_proyecto.login.ui.viewmodels

import android.app.Application
import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.ColorFilter
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.moviles_223251_proyecto.core.domain.models.TextFieldConfig
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.login.data.services.LoginService
import com.example.moviles_223251_proyecto.login.domain.dtos.LoginUserDto
import com.example.moviles_223251_proyecto.login.domain.models.LoginState
import kotlinx.coroutines.launch

class LoginViewModel(app: Application) : AndroidViewModel(app) {

    private val email = mutableStateOf("")
    private val password = mutableStateOf("")
    private val loginService = LoginService()
    val loginState = mutableStateOf<LoginState>(LoginState.Idle)

    fun getTextFields(): List<TextFieldConfig> {
        return listOf(
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
            )
        )
    }

    private fun getLoginUserDto(): LoginUserDto {
        return LoginUserDto(email = email.value, password = password.value)
    }

    fun loginUser() {
        val loginUserDto = getLoginUserDto()

        if (loginUserDto.isValid()) {
            viewModelScope.launch {
                loginState.value = LoginState.Loading
                val result = loginService.login(loginUserDto)

                result.fold(
                    onSuccess = { tokenResponse ->
                        loginState.value = LoginState.Success(tokenResponse)
                    },
                    onFailure = { exception ->
                        loginState.value = LoginState.Error(exception.message ?: "Error desconocido")
                    }
                )
                email.value = ""
                password.value = ""
            }
        } else {
            loginState.value = LoginState.Error("Email o contraseña inválida")
        }
    }

    fun restartLoginState() {
        loginState.value = LoginState.Idle
    }
}
