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
import com.example.moviles_223251_proyecto.core.domain.TextFieldConfig
import com.example.moviles_223251_proyecto.login.domain.dtos.LoginUserDto

class LoginViewModel(app: Application) : AndroidViewModel(app) {

    private val email = mutableStateOf("")
    private val password = mutableStateOf("")

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
}
