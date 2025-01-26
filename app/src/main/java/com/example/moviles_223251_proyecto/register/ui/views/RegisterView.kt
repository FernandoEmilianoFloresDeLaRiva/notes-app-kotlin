package com.example.moviles_223251_proyecto.register.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutAuth
import com.example.moviles_223251_proyecto.core.domain.constants.Routes
import com.example.moviles_223251_proyecto.core.navigation.states.navigateTo
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider

@Composable
fun RegisterView(
    router: MutableState<String> = LocalRouter.current
) {
    val registerViewModel = LocalViewModelProvider.current.registerViewModel
    LayoutAuth(
        textFields = registerViewModel.getTextFields(),
        layoutTitle = "¡Registrate!",
        primaryButtonTitle = "Crea tu cuenta",
        primaryButtonAction = {  },
        secondaryButtonTitle = "¿Ya tienes una cuenta?, Inicia Sesión",
        secondaryButtonAction = {
            router.navigateTo(Routes.LoginRoute.route)
        },
    )
}
