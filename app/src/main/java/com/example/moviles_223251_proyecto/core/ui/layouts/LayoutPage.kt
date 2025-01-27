package com.example.moviles_223251_proyecto.core.ui.layouts

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviles_223251_proyecto.core.ui.composables.navbar.NavBar
import com.example.moviles_223251_proyecto.core.ui.composables.topbar.TopBar

@Composable
fun LayoutPage(content : @Composable (Modifier) -> Unit, username : String = "") {
    Scaffold(
        topBar = { TopBar( username)},
        bottomBar = { NavBar() }
    ){
        content(Modifier.padding(it))
    }
}