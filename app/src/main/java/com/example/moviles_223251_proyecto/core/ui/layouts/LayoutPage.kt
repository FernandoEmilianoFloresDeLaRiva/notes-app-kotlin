package com.example.moviles_223251_proyecto.core.ui.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviles_223251_proyecto.routes.data.Routes
import com.example.moviles_223251_proyecto.core.ui.composables.navbar.NavBar

@Composable
fun LayoutPage(
    content : @Composable (Modifier) -> Unit,
    selectedRoute : String = Routes.HomeRoute.route,
    onChangeRoute : (String) -> Unit
) {
    Scaffold(
        topBar = {},
        bottomBar = {
            NavBar(
                selectedRoute = selectedRoute,
                onChange = {
                    onChangeRoute(it)
                })
        }
    ){
        content(Modifier.padding(it))
    }
}