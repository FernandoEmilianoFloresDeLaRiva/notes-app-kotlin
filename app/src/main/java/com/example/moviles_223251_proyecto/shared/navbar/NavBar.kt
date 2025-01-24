package com.example.moviles_223251_proyecto.shared.navbar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviles_223251_proyecto.routes.data.Routes
import com.example.moviles_223251_proyecto.shared.navbar.composables.itembar.ItemBar

@Composable
fun NavBar(
    selectedRoute : String = Routes.HomeRoute.route,
    onChange : (String) -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .background(
                MaterialTheme.colorScheme.primary
            )
            .padding(12.dp)
            .fillMaxWidth()
    ){
        for(page in Routes.pages) {
            ItemBar(
                page,
                selected = selectedRoute == page.route,
                modifier = Modifier.clickable {
                    onChange(page.route)
                }
            )
        }
    }
}