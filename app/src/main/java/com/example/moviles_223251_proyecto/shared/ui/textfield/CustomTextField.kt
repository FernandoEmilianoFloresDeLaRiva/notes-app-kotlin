package com.example.moviles_223251_proyecto.shared.ui.textfield

import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CustomTextField(
    value : String = "",
    onValueChange : (String) -> Unit,
    modifier: Modifier = Modifier,
    label : @Composable () -> Unit,
    colors : TextFieldColors = TextFieldDefaults.colors(),
    leadingIcon : @Composable (() -> Unit)? = null,
    trailingIcon : @Composable (() -> Unit)? = null
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        label =  label,
        colors = colors,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
    )
}