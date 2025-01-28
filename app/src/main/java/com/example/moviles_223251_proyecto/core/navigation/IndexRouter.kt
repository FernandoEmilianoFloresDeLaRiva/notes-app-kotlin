package com.example.moviles_223251_proyecto.core.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.moviles_223251_proyecto.core.SharedPreference.TokenProvider
import com.example.moviles_223251_proyecto.core.domain.constants.Routes
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.core.navigation.states.currentRoute
import com.example.moviles_223251_proyecto.core.navigation.states.navigateTo
import com.example.moviles_223251_proyecto.createnote.ui.pages.CreateNotePage
import com.example.moviles_223251_proyecto.home.ui.pages.HomePage
import com.example.moviles_223251_proyecto.login.ui.views.LoginView
import com.example.moviles_223251_proyecto.register.ui.views.RegisterView

@Composable
fun IndexRouter(tokenProvider: TokenProvider) {
    val routerState = LocalRouter.current

    LaunchedEffect(Unit) {
        val token = tokenProvider.getToken()
        if (token.isNullOrEmpty()) {
            routerState.navigateTo(Routes.LoginRoute.route)
        } else {
            routerState.navigateTo(Routes.HomeRoute.route)
        }
    }

    Crossfade(
        targetState = routerState.currentRoute(),
        label = "Animation Crossfade For Router"
    ) {
        targetState ->
        when (targetState) {
            Routes.LoginRoute.route -> LoginView(routerState)
            Routes.RegisterRoute -> RegisterView(routerState)
            Routes.HomeRoute.route -> HomePage()
            Routes.CreateRoute.route -> CreateNotePage()
        }
    }
}