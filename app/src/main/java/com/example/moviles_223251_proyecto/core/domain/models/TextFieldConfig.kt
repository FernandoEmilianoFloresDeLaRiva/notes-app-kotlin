package com.example.moviles_223251_proyecto.core.domain.models

import androidx.compose.runtime.Composable

data class TextFieldConfig(
    val value: String,
    val onValueChange: (String) -> Unit,
    val label: String,
    val leadingIcon: @Composable (() -> Unit)? = null
)
