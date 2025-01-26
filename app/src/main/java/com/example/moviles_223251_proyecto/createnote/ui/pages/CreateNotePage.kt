package com.example.moviles_223251_proyecto.createnote.ui.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.moviles_223251_proyecto.core.ui.layouts.LayoutPage

@Composable
fun CreateNotePage() {
    LayoutPage(
        content = { modifier ->
            Column(modifier = modifier) {
                Text(text = "Create note Page")
            }
        }
    )
}