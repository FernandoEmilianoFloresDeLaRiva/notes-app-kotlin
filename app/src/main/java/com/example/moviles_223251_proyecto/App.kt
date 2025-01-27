package com.example.moviles_223251_proyecto

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviles_223251_proyecto.core.navigation.IndexRouter
import com.example.moviles_223251_proyecto.core.navigation.states.RouterProvider
import com.example.moviles_223251_proyecto.core.domain.constants.Routes
import com.example.moviles_223251_proyecto.core.ui.theme.Moviles_223251_proyectoTheme

@Composable
fun App(modifier: Modifier = Modifier) {
    Moviles_223251_proyectoTheme {
        RouterProvider(Routes.HomeRoute.route){
            IndexRouter()
        }
    }
}