package com.example.moviles_223251_proyecto.shared.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun CustomText(
    text : String = "",
    fontSize : TextUnit = 12.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color : Color = Color.Black
) {
    Text(
        text = text,
        fontSize = fontSize,
        fontWeight = fontWeight,
        color = color
    )
}