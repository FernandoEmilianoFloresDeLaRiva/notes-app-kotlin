package com.example.moviles_223251_proyecto.core.navigation.states

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.compositionLocalOf

// CompositionLocal para manejar el estado del router
val LocalRouter = compositionLocalOf<MutableState<String>> {
    error("LocalRouter no está inicializado. Envuelve a tu hijo con RouterProvider.")
}

fun MutableState<String>.navigateTo(route: String) {
    this.value = route
}

fun MutableState<String>.currentRoute(): String = this.value