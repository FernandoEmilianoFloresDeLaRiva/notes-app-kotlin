package com.example.moviles_223251_proyecto.core.ui.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviles_223251_proyecto.core.ui.composables.navbar.NavBar

@Composable
fun LayoutPage(content : @Composable (Modifier) -> Unit, ) {
    Scaffold(
        topBar = {},
        bottomBar = { NavBar() }
    ){
        content(Modifier.padding(it))
    }
}