package com.example.moviles_223251_proyecto.core.navigation

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviles_223251_proyecto.core.navigation.states.LocalRouter
import com.example.moviles_223251_proyecto.core.domain.constants.Routes
import com.example.moviles_223251_proyecto.core.navigation.states.currentRoute
import com.example.moviles_223251_proyecto.createnote.ui.pages.CreateNotePage
import com.example.moviles_223251_proyecto.home.ui.pages.HomePage
import com.example.moviles_223251_proyecto.login.ui.views.LoginView
import com.example.moviles_223251_proyecto.register.ui.views.RegisterView

@Preview
@Composable
fun IndexRouter(modifier: Modifier = Modifier) {
    val routerState = LocalRouter.current
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