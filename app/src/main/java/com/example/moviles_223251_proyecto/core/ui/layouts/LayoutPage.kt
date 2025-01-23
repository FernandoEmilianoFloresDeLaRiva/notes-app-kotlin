package com.example.moviles_223251_proyecto.core.ui.layouts

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun LayoutPage(children : @Composable () -> Unit) {
    Scaffold(
        topBar = {},
        bottomBar = {}
    ){
        innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)){
            children()
        }
    }
}