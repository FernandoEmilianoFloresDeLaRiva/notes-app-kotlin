package com.example.moviles_223251_proyecto.login.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import com.example.moviles_223251_proyecto.core.domain.constants.Routes
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.core.navigation.states.navigateTo
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutAuth
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider
import com.example.moviles_223251_proyecto.login.domain.models.LoginState
import com.example.moviles_223251_proyecto.shared.ui.errormessage.ErrorMessage
import com.example.moviles_223251_proyecto.shared.ui.loader.Loader
import com.example.moviles_223251_proyecto.shared.ui.successmessage.SuccessMessage

@Composable
fun LoginView(
    router: MutableState<String> = LocalRouter.current
) {
    val loginViewModel = LocalViewModelProvider.current.loginViewModel
    val loginState by loginViewModel.loginState

    LayoutAuth(
        textFields = loginViewModel.getTextFields(),
        layoutTitle = "¡Ingresa a tus notas!",
        primaryButtonTitle = "Inicia Sesión",
        primaryButtonAction = { loginViewModel.loginUser() },
        secondaryButtonTitle = "¿No cuentas con una cuenta?",
        secondaryButtonAction = {
            router.navigateTo(Routes.RegisterRoute)
        }
    )

    if (loginState is LoginState.Success) {
        SuccessMessage(message = "Inicio de sesión exitoso")
        router.navigateTo(Routes.HomeRoute.route)
        loginViewModel.restartLoginState()
    }

    if(loginState is LoginState.Loading){
        Loader()
    }else if(loginState is LoginState.Error){
        val errorMessage = (loginState as LoginState.Error).message
        ErrorMessage(message = errorMessage)
    }
}