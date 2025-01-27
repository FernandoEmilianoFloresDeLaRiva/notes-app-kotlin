package com.example.moviles_223251_proyecto.core.ui.composables.topbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TopBar(username : String = "") {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .padding(vertical = 30.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.padding(start = 23.dp, top = 15.dp),
            text = "Hola, $username",
            color = MaterialTheme.colorScheme.surfaceContainer,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}