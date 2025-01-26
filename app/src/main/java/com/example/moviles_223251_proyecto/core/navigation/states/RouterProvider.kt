package com.example.moviles_223251_proyecto.core.navigation.states

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import com.example.moviles_223251_proyecto.core.domain.constants.Routes

@Composable
fun RouterProvider(
    initialRoute: String = Routes.LoginRoute.route,
    content: @Composable () -> Unit
) {
    val routerState = rememberSaveable{mutableStateOf(initialRoute) }

    // Proveer el estado a través de CompositionLocal
    CompositionLocalProvider(LocalRouter provides routerState) {
        content()
    }
}