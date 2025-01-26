package com.example.moviles_223251_proyecto.home.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage

@Composable
fun HomePage() {
    LayoutPage(
        content = { modifier ->
            Column(modifier = modifier) {
                Text(text = "Home Page")
            }
        }
    )
}