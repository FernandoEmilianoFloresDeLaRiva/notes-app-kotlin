package com.example.moviles_223251_proyecto.core.ui.styles.LayoutAppForm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp

object LayoutAppFormStyles {
    fun boxStyle(modifier: Modifier = Modifier,colorScheme: ColorScheme): Modifier {
        return modifier
            .padding(horizontal = 20.dp, vertical = 50.dp)
            .graphicsLayer {
                shadowElevation = 15.dp.toPx()
                shape = RoundedCornerShape(15.dp)
                clip = true
            }
            .background(
                color = colorScheme.surface,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(24.dp)
    }

    @Composable
    fun getTextFieldColors(colorScheme: ColorScheme) = TextFieldDefaults.colors(
        focusedContainerColor = colorScheme.primaryContainer,
        unfocusedContainerColor = colorScheme.background,
        cursorColor = colorScheme.primary,
        focusedIndicatorColor = colorScheme.primary,
        unfocusedIndicatorColor = Color.Transparent
    )
}