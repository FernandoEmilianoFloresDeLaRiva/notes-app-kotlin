package com.example.moviles_223251_proyecto.routes.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage
import com.example.moviles_223251_proyecto.core.ui.theme.Moviles_223251_proyectoTheme
import com.example.moviles_223251_proyecto.login.ui.views.LoginView
import com.example.moviles_223251_proyecto.routes.data.Routes

@Preview
@Composable
fun IndexRouter(modifier: Modifier = Modifier) {
    val routerValue = remember {
        mutableStateOf(Routes.LoginRoute.route)
    }
    Moviles_223251_proyectoTheme {
        when (routerValue.value){
            Routes.LoginRoute.route -> Text(text = "LoginPage")
            Routes.RegisterRoute -> Text(text = "RegisterPage")
            Routes.HomeRoute.route -> LayoutPage(children = { LoginView() })
            Routes.CreateRoute.route -> Text(text = "CreateRoute")
        }
    }
}