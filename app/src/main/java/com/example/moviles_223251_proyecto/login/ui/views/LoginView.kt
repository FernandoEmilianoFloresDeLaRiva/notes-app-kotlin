package com.example.moviles_223251_proyecto.login.ui.views

import androidx.compose.foundation.Image
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.ColorFilter
import com.example.moviles_223251_proyecto.core.domain.TextFieldConfig
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutAuth
import com.example.moviles_223251_proyecto.core.navigation.states.Routes
import com.example.moviles_223251_proyecto.core.navigation.states.navigateTo

@Composable
fun LoginView(
    router: MutableState<String> = LocalRouter.current
) {

    val textFields = listOf(
        TextFieldConfig(
            value = "",
            onValueChange = { },
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
            value = "",
            onValueChange = { },
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
    LayoutAuth(
        textFields = textFields,
        layoutTitle = "¡Ingresa a tus notas!",
        primaryButtonTitle = "Inicia Sesión",
        primaryButtonAction = {  },
        secondaryButtonTitle = "¿No cuentas con una cuenta?",
        secondaryButtonAction = {
            router.navigateTo(Routes.RegisterRoute)
        }
    )
}