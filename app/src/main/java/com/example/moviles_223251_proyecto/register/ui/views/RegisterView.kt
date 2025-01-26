package com.example.moviles_223251_proyecto.register.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutAuth
import com.example.moviles_223251_proyecto.core.domain.constants.Routes
import com.example.moviles_223251_proyecto.core.navigation.states.navigateTo
import com.example.moviles_223251_proyecto.core.vmprovider.states.LocalViewModelProvider
import com.example.moviles_223251_proyecto.register.domain.models.RegisterState
import com.example.moviles_223251_proyecto.shared.ui.errormessage.ErrorMessage
import com.example.moviles_223251_proyecto.shared.ui.loader.Loader
import com.example.moviles_223251_proyecto.shared.ui.successmessage.SuccessMessage
import kotlinx.coroutines.delay

@Composable
fun RegisterView(
    router: MutableState<String> = LocalRouter.current
) {
    val registerViewModel = LocalViewModelProvider.current.registerViewModel
    val registerState by registerViewModel.registerState

    LayoutAuth(
        textFields = registerViewModel.getTextFields(),
        layoutTitle = "¡Registrate!",
        primaryButtonTitle = "Crea tu cuenta",
        primaryButtonAction = {  registerViewModel.registerUser()},
        secondaryButtonTitle = "¿Ya tienes una cuenta?, Inicia Sesión",
        secondaryButtonAction = {
            router.navigateTo(Routes.LoginRoute.route)
        },
    )

    if(registerState is RegisterState.Success){
        val email = (registerState as RegisterState.Success).userResponse.email
        SuccessMessage(message = "¡Registro exitoso con correo $email!, Inicia Sesión")
        LaunchedEffect(Unit) {
            delay(2000)
            registerViewModel.restartRegisterState()
        }
    }

    if(registerState is RegisterState.Loading){
        Loader()
    }else if(registerState is RegisterState.Error){
        ErrorMessage(message = (registerState as RegisterState.Error).message)
    }
}
