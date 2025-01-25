package com.example.moviles_223251_proyecto.login.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.core.navigation.states.Routes
import com.example.moviles_223251_proyecto.core.navigation.states.navigateTo
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutAuth
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider

@Composable
fun LoginView(
    router: MutableState<String> = LocalRouter.current
) {
    val loginViewModel = LocalViewModelProvider.current.loginViewModel
    LayoutAuth(
        textFields = loginViewModel.getTextFields(),
        layoutTitle = "¡Ingresa a tus notas!",
        primaryButtonTitle = "Inicia Sesión",
        primaryButtonAction = {  },
        secondaryButtonTitle = "¿No cuentas con una cuenta?",
        secondaryButtonAction = {
            router.navigateTo(Routes.RegisterRoute)
        }
    )
}