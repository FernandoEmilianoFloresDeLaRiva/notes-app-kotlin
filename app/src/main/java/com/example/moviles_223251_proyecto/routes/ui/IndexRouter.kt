package com.example.moviles_223251_proyecto.routes.ui

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviles_223251_proyecto.core.ui.theme.Moviles_223251_proyectoTheme
import com.example.moviles_223251_proyecto.createnote.ui.pages.CreateNotePage
import com.example.moviles_223251_proyecto.home.ui.pages.HomePage
import com.example.moviles_223251_proyecto.login.ui.views.LoginView
import com.example.moviles_223251_proyecto.register.ui.views.RegisterView
import com.example.moviles_223251_proyecto.routes.data.Routes

@Preview
@Composable
fun IndexRouter(modifier: Modifier = Modifier) {
    val routerValue = remember {
        mutableStateOf(Routes.HomeRoute.route)
    }
    Moviles_223251_proyectoTheme {
        Crossfade(
            targetState = routerValue.value,
            label = "Animation Crossfade For Router"
        ) {
            targetState ->
            when (targetState) {
                Routes.LoginRoute.route -> LoginView(routerValue)
                Routes.RegisterRoute -> RegisterView(routerValue)
                Routes.HomeRoute.route -> HomePage(
                    selectedRoute = routerValue.value,
                    onChangeRoute = { routerValue.value = it }
                )

                Routes.CreateRoute.route -> CreateNotePage(
                    selectedRoute = routerValue.value,
                    onChangeRoute = { routerValue.value = it }
                )
            }
        }
    }
}