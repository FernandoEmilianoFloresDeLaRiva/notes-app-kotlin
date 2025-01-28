package com.example.moviles_223251_proyecto

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.example.moviles_223251_proyecto.core.SharedPreference.TokenProvider
import com.example.moviles_223251_proyecto.core.domain.constants.Routes
import com.example.moviles_223251_proyecto.core.navigation.IndexRouter
import com.example.moviles_223251_proyecto.core.navigation.states.RouterProvider
import com.example.moviles_223251_proyecto.core.ui.theme.Moviles_223251_proyectoTheme

@Composable
fun App(ctx : Context) {
    val tokenProvider = remember { TokenProvider(ctx) }
    Moviles_223251_proyectoTheme {
        RouterProvider(Routes.LoginRoute.route){
            IndexRouter(tokenProvider = tokenProvider)
        }
    }
}